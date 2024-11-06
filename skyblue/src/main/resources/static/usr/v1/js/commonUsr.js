const stars = document.querySelectorAll('#mystar label');
  
      // 별에 마우스 올렸을 때 해당 별과 왼쪽 별들 채우기
      stars.forEach(star => {
          star.addEventListener('mouseover', () => {
              const value = parseInt(star.getAttribute('data-value'));
              stars.forEach((s, index) => {
                  if (index < value) {
                      s.style.color = 'rgba(250, 208, 0, 0.99)';
                  } else {
                      s.style.color = 'transparent';
                  }
              });
          });
  
          // 마우스가 별 밖으로 나가면 별 초기화
          star.addEventListener('mouseout', () => {
              stars.forEach(s => s.style.color = 'transparent');
          });
  
          // 별 클릭 시 선택 상태 유지
          star.addEventListener('click', () => {
              const value = parseInt(star.getAttribute('data-value'));
              stars.forEach((s, index) => {
                  if (index < value) {
                      s.style.color = 'rgba(250, 208, 0, 0.99)';
                  } else {
                      s.style.color = 'transparent';
                  }
              });
          });
      });