$(document).ready(function () {
    var matchNo = "31"; // 여기에 원하는 matchNo를 넣어주세요.

        // AJAX GET 요청을 보냅니다.
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/matchInfo", // 요청할 URL
            data: {
                matchNo: matchNo // matchNo 파라미터를 설정하여 전달
            },
            dataType: "json",
            success: function (response) {
                // 요청이 성공했을 때 처리할 코드
                console.log("경기 정보:", response);

                // 경기 정보를 화면에 표시
                $("#matchNo").text(response.matchNo);
                $("#homeTeam").text(response.homeTeam);
                $("#awayTeam").text(response.awayTeam);
                $("#stadiumName").text(response.stadiumName);
            },
            error: function () {
                // 요청이 실패했을 때 처리할 코드
                console.error("경기 정보를 불러오는데 실패했습니다.");
            }
        });
      });
      
                // 경기장 정보를 가져오는 Ajax 요청
                $.ajax({
                    type: "GET",
                    url: "http://localhost:8080/stadium", // 경기장 정보를 반환하는 엔드포인트 URL
                    dataType: "json",
                    success: function (stadiumInfo) {
                        // 성공적으로 데이터를 가져온 경우 처리
                        console.log("경기장 정보:", stadiumInfo);
                        
                        // 여기에서 stadiumInfo를 이용하여 프론트엔드에 경기장 정보를 표시하거나 활용할 수 있습니다.
                    },
                    error: function () {
                        // 요청이 실패한 경우 처리
                        console.error("경기장 정보를 가져오는데 실패했습니다.");
                    }
                });

            // 좌석 구역 정보를 가져오는 Ajax 요청
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/seatAreaNo", // 엔드포인트 URL
                dataType: "json",
                success: function (seatAreas) {
                    // 성공적으로 데이터를 가져온 경우 처리
                    console.log("좌석 구역 정보:", seatAreas);
                    
                    // 여기에서 seatAreas를 이용하여 프론트엔드에 좌석 구역 정보를 표시하거나 활용할 수 있습니다.
                },
                error: function () {
                    // 요청이 실패한 경우 처리
                    console.error("좌석 구역 정보를 가져오는데 실패했습니다.");
                }
            });
        
            // 좌석 번호 정보를 가져오는 Ajax 요청
            $.ajax({
                type: "GET",
                url: "http://localhost:8080/seatNo", // 엔드포인트 URL
                dataType: "json",
                success: function (seatNumbers) {
                    // 성공적으로 데이터를 가져온 경우 처리
                    console.log("좌석 번호 정보:", seatNumbers);
                    
                    // 여기에서 seatNumbers를 이용하여 프론트엔드에 좌석 번호 정보를 표시하거나 활용할 수 있습니다.
                },
                error: function () {
                    // 요청이 실패한 경우 처리
                    console.error("좌석 번호 정보를 가져오는데 실패했습니다.");
                }
            });

        // 좌석 예매 버튼 클릭 이벤트 핸들러
        $("#reserveButton").click(function () {
            // 사용자가 선택한 정보 가져오기
            var selectedZone = $("#zoneSelect").val();
            var seatNumber = $("#seatNumber").val();

            // 좌석 예매 요청 데이터 생성
            var reservationData = {
                zone: selectedZone,
                seatNumber: seatNumber
            };

            // 좌석 예매 API 엔드포인트로 데이터 전송
            $.ajax({
                url: "http://localhost:8080/seat", // 백엔드에서 좌석 예매 처리 API 엔드포인트
                method: "POST",
                dataType: "json",
                data: JSON.stringify(reservationData),
                contentType: "application/json",
                success: function (response) {
                    // 성공적으로 좌석 예매가 처리된 경우
                    alert("좌석 예매가 완료되었습니다. 예매 번호: " + response.bookingNumber);
                },
                error: function () {
                    // 좌석 예매에 실패한 경우
                    alert("좌석 예매에 실패했습니다. 다시 시도해주세요.");
                }
            });
        });