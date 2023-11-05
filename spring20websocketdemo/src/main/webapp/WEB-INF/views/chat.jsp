<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
    <html lang="en" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<th:block th:replace="~{/layout/basic :: setContent(~{this :: content})}">
    <th:block th:fragment="content">
    
        <div class="container">
            <div class="col-6">
                <label><b>ä�ù�</b></label>
            </div>
            <div>
                <div id="msgArea" class="col"></div>
                <div class="col-6">
                    <div class="input-group mb-3">
                        <input type="text" id="msg" class="form-control" aria-label="Recipient's username" aria-describedby="button-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-outline-secondary" type="button" id="button-send">����</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </th:block>
</th:block>

<script th:inline="javascript">
            $(document).ready(function(){

            const username = [[${#authentication.principal.username}]];

            $("#disconn").on("click", (e) => {
                disconnect();
            })
            
            $("#button-send").on("click", (e) => {
                send();
            });

            const websocket = new WebSocket("ws://localhost:8080/ws/chat");

            websocket.onmessage = onMessage;
            websocket.onopen = onOpen;
            websocket.onclose = onClose;

            function send(){

                let msg = document.getElementById("msg");

                console.log(username + ":" + msg.value);
                websocket.send(username + ":" + msg.value);
                msg.value = '';
            }
            
            //ä��â���� ������ ��
            function onClose(evt) {
                var str = username + ": ���� ���� �����̽��ϴ�.";
                websocket.send(str);
            }
            
            //ä��â�� ������ ��
            function onOpen(evt) {
                var str = username + ": ���� �����ϼ̽��ϴ�.";
                websocket.send(str);
            }

            function onMessage(msg) {
                var data = msg.data;
                var sessionId = null;
                //�����͸� ���� ���
                var message = null;
                var arr = data.split(":");

                for(var i=0; i<arr.length; i++){
                    console.log('arr[' + i + ']: ' + arr[i]);
                }

                var cur_session = username;

                //���� ���ǿ� �α��� �� ���
                console.log("cur_session : " + cur_session);
                sessionId = arr[0];
                message = arr[1];

                console.log("sessionID : " + sessionId);
                console.log("cur_session : " + cur_session);

                //�α��� �� Ŭ���̾�Ʈ�� Ÿ Ŭ���̾�Ʈ�� �з��ϱ� ����
                if(sessionId == cur_session){
                    var str = "<div class='col-6'>";
                    str += "<div class='alert alert-secondary'>";
                    str += "<b>" + sessionId + " : " + message + "</b>";
                    str += "</div></div>";
                    $("#msgArea").append(str);
                }
                else{
                    var str = "<div class='col-6'>";
                    str += "<div class='alert alert-warning'>";
                    str += "<b>" + sessionId + " : " + message + "</b>";
                    str += "</div></div>";
                    $("#msgArea").append(str);
                }
            }
            })
</script>


<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>

</body>
</html>