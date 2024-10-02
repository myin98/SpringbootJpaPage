const slideInterval = 5000; // 슬라이드 전환 간격 (5초)
const reviewWrapper = document.querySelector('.review-wrapper');
const reviewSlides = Array.from(document.querySelectorAll('.review-slide'));

let currentIndex = 0;

// 슬라이드 너비를 설정하는 함수
function updateSlideWidth() {
    // 미디어 쿼리를 사용하여 현재 화면 너비를 확인
    const isSmallScreen = window.matchMedia("(max-width: 861px)").matches;

    if (isSmallScreen) {
        // 화면 너비가 861px 이하일 때: 슬라이드 너비를 100%로 설정
        reviewSlides.forEach(slide => slide.style.width = '100%');
    } else {
        // 화면 너비가 861px 이상일 때: 슬라이드 너비를 25%로 설정
        reviewSlides.forEach(slide => slide.style.width = '25%');
    }
}

// 슬라이드를 이동시키는 함수
function moveToNextSlide() {
    currentIndex = (currentIndex + 1) % reviewSlides.length;
    const isSmallScreen = window.matchMedia("(max-width: 861px)").matches;
    const offset = isSmallScreen ? -currentIndex * 100 : -currentIndex * 25; // 100% 또는 25%
    reviewWrapper.style.transform = `translateX(${offset}%)`;
}

// 페이지 로드 시 초기 위치 설정 및 슬라이드 너비 업데이트
updateSlideWidth();
reviewWrapper.style.transform = `translateX(0%)`;

// 슬라이드 전환을 주기적으로 실행
setInterval(moveToNextSlide, slideInterval);

// 화면 크기 변경 시 슬라이드 너비와 위치를 업데이트
window.addEventListener('resize', () => {
    updateSlideWidth();
    moveToNextSlide(); // 크기 변경 시 현재 슬라이드가 계속 보이도록 조정
});
