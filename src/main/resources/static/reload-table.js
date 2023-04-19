let form = document.querySelector('form');
form.addEventListener('submit',(e) => {
    closePopup();
    setTimeout(function () { location.reload(true); }, 100);
});

function closePopup(){
    let popup = document.querySelector('.popup');
    let popupBg = document.querySelector('.popup-background');
    popupBg.classList.remove('active');
    popup.classList.remove('active');
}