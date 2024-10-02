 const slideInterval = 5000; // 슬라이드 전환 간격 (5초)
    const reviewWrapper = document.querySelector('.review-wrapper');
    const reviewSlides = Array.from(document.querySelectorAll('.review-slide'));

    let currentIndex = 0;

    function moveToNextSlide() {
        currentIndex = (currentIndex + 1) % reviewSlides.length;
        const offset = -currentIndex * 25; // 슬라이드 너비의 25% (4개 카드가 보이도록 설정)
        reviewWrapper.style.transform = `translateX(${offset}%)`;
    }

    setInterval(moveToNextSlide, slideInterval);

    // 페이지 로드 시 초기 위치 설정
    reviewWrapper.style.transform = `translateX(0%)`;
    