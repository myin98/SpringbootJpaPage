  function showTab(tabId) {
            document.querySelectorAll('.tab-content').forEach(tab => {
                tab.style.display = 'none';
            });
            document.getElementById(tabId).style.display = 'block';

            document.querySelectorAll('.tab-buttons button').forEach(button => {
                button.classList.remove('active');
            });
            document.querySelector(`.tab-buttons button[onclick="showTab('${tabId}')"]`).classList.add('active');
        }