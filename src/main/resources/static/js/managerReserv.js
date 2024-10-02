    // 예약 데이터 배열
    let reservations = [
        { id: '0001', restaurant: '맛있는 식당', customer: '홍길동', date: '2024-08-20', time: '18:00', guests: '4명', status: '확정' },
        { id: '0002', restaurant: '즐거운 레스토랑', customer: '김영희', date: '2024-08-21', time: '19:00', guests: '2명', status: '확정' },
        { id: '0003', restaurant: '멋진 카페', customer: '이철수', date: '2024-08-22', time: '15:00', guests: '3명', status: '대기' },
        { id: '0004', restaurant: '멋진 카페', customer: '이철수', date: '2024-08-22', time: '15:00', guests: '3명', status: '대기' },
        { id: '0005', restaurant: '멋진 카페', customer: '이철수', date: '2024-08-22', time: '15:00', guests: '3명', status: '대기' },
        { id: '0006', restaurant: '멋진 카페', customer: '이철수', date: '2024-08-22', time: '15:00', guests: '3명', status: '대기' },
        { id: '0007', restaurant: '멋진 카페', customer: '이철수', date: '2024-08-22', time: '15:00', guests: '3명', status: '대기' },
        // 더 많은 예약 데이터 추가
    ];

    const itemsPerPage = 5; // 페이지당 표시할 항목 수
    let currentPage = 1; // 현재 페이지
    let currentStatusFilter = '전체'; // 현재 필터 상태
    let searchQuery = ''; // 현재 검색어

    // 예약 목록을 렌더링하는 함수
    function renderReservations() {
        const container = document.getElementById('reservation-container');
        container.innerHTML = '';

        // 현재 페이지에 맞는 예약 항목 추출
        const startIndex = (currentPage - 1) * itemsPerPage;
        const endIndex = startIndex + itemsPerPage;

        // 필터링 및 검색된 예약 목록을 페이지에 맞게 잘라내기
        const filteredReservations = reservations.filter(reservation => {
            return (currentStatusFilter === '전체' || reservation.status === currentStatusFilter) &&
                   (reservation.customer.includes(searchQuery) || reservation.restaurant.includes(searchQuery));
        });
        const pageReservations = filteredReservations.slice(startIndex, endIndex);

        pageReservations.forEach((reservation) => {
            const div = document.createElement('div');
            div.classList.add('reservation-item');
            div.innerHTML = `
                <h3>예약 ID: ${reservation.id}</h3>
                <p>고객 이름: ${reservation.customer} <span class="status ${reservation.status}">${reservation.status}</span></p>
                ${reservation.status === '대기' ? '<button class="cancel-button" onclick="cancelReservation(event, \'' + reservation.id + '\')">예약 취소</button>' : ''}
                <div class="reservation-details">
                    <p><strong>상세 정보:</strong></p>
                    <p>예약 ID: ${reservation.id}</p>
                    <p>음식점 이름: ${reservation.restaurant}</p>
                    <p>고객 이름: ${reservation.customer}</p>
                    <p>예약 날짜: ${reservation.date}</p>
                    <p>예약 시간: ${reservation.time}</p>
                    <p>인원 수: ${reservation.guests}</p>
                    <p>상태: ${reservation.status}</p>
                </div>
            `;
            div.onclick = function() {
                const details = this.querySelector('.reservation-details');
                if (details.classList.contains('open')) {
                    details.classList.remove('open');
                } else {
                    // 닫힌 상태일 때, 열린 상태를 자동으로 닫기
                    document.querySelectorAll('.reservation-details.open').forEach(detail => {
                        detail.classList.remove('open');
                    });
                    details.classList.add('open');
                }
            };
            container.appendChild(div);
        });

        // 페이지네이션 버튼 활성화/비활성화 설정
        document.getElementById('prev-button').disabled = currentPage === 1;
        document.getElementById('next-button').disabled = endIndex >= filteredReservations.length;
    }

    // 페이지를 변경하는 함수
    function changePage(direction) {
        currentPage += direction;
        renderReservations();
    }

    // 예약을 취소하는 함수
    function cancelReservation(event, id) {
        event.stopPropagation(); // 클릭 이벤트가 상세보기 전환을 방지
        if (confirm('정말로 예약을 취소하시겠습니까?')) {
            // 예약 상태를 '취소'로 변경
            const reservation = reservations.find(reservation => reservation.id === id);
            if (reservation) {
                reservation.status = '취소';
                renderReservations(); // 업데이트된 예약 목록 렌더링
            }
        }
    }

    // 예약 상태를 필터링하는 함수
    function filterReservations(status) {
        currentStatusFilter = status;
        currentPage = 1; // 필터링 시 첫 페이지로 이동
        renderReservations();
    }

    // 예약 목록을 검색하는 함수
    function searchReservations() {
        searchQuery = document.getElementById('search-input').value;
        currentPage = 1; // 검색 시 첫 페이지로 이동
        renderReservations();
    }

    renderReservations(); // 초기 페이지 렌더링