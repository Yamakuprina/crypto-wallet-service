let form = document.querySelector('form');

let uiLanguage = document.getElementById("ui-language");
let uiCurrency = document.getElementById("ui-currency");
let uiTheme = document.getElementById("ui-theme");

form.addEventListener('submit', (e) => {
    e.preventDefault();
    let language = uiLanguage.value;
    let currency = uiCurrency.value;
    let theme = uiTheme.value;
    let mfa = false;
    fetch('/user/settings?' + new URLSearchParams({
        userId: sessionStorage.getItem('userID'),
    }), {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id: null,
            language: language,
            currency: currency,
            theme: theme,
            enableMFA: mfa
        })
    });
    setTimeout(function () { location.reload(true); }, 200);
});