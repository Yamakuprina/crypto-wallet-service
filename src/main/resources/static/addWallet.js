let form = document.querySelector('form');

let walletCurrency = document.getElementById("wallet-currency");

form.addEventListener('submit', (e) => {
    e.preventDefault();
    let walletCurr = walletCurrency.value;
    let userId = sessionStorage.getItem('userID')
    fetch('/wallet', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            userId: userId,
            currency: walletCurr,
        })
    });
    closePopup()
    setTimeout(function () { location.reload(true); }, 300);
});

function closePopup(){
    let popup = document.querySelector('.popup');
    let popupBg = document.querySelector('.popup-background');
    popupBg.classList.remove('active');
    popup.classList.remove('active');
}