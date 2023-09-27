 // 현재 날짜를 가져오기
 var today = new Date();
 var currentYear = today.getFullYear();
 var currentMonth = today.getMonth();

 // 월별 달력 생성 함수
 function generateCalendar(year, month) {
     var calendar = document.getElementById("calendar");
     calendar.innerHTML = ""; // 달력 초기화

     var daysInMonth = new Date(year, month + 1, 0).getDate(); // 해당 월의 일 수 계산
     var firstDay = new Date(year, month, 1).getDay(); // 첫째 날의 요일 계산 (0은 일요일, 1은 월요일, ...)

     // 월별 달력 생성
     var table = document.createElement("table");
     var row = table.insertRow();
     var weekdays = ["일", "월", "화", "수", "목", "금", "토"];

     // 요일 헤더 생성
     for (var i = 0; i < 7; i++) {
         var cell = row.insertCell();
         cell.innerHTML = weekdays[i];
     }

     // 날짜 채우기
     var date = 1;
     for (var i = 0; i < 6; i++) {
         if (date > daysInMonth) {
             break;
         }
         row = table.insertRow();
         for (var j = 0; j < 7; j++) {
             if (i === 0 && j < firstDay) {
                 // 첫째 주에서 첫째 날 이전의 빈 칸
                 var cell = row.insertCell();
                 cell.innerHTML = "";
             } else {
                 if (date <= daysInMonth) {
                     // 데이터를 가져와서 표시하도록 수정하세요.
                     var cell = row.insertCell();
                     cell.innerHTML = date; // 날짜 표시
                     // 이 부분에 데이터를 표시하는 로직을 추가하세요.

                     date++;
                 }
             }
         }
     }

     calendar.appendChild(table);
 }

 // 월별 달력 생성
 generateCalendar(currentYear, currentMonth);