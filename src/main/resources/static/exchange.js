let form = document.querySelector('form');

let senderWallet = document.getElementById("sender-wallet");
let receiverWallet = document.getElementById("receiver-wallet");
let initCurrency = document.getElementById("init-currency");
let targetCurrency = document.getElementById("target-currency");
let exchangeAmount = document.getElementById("transaction-amount");

form.addEventListener('submit', (e) => {
    e.preventDefault();
    let sender = senderWallet.value;
    let receiver = receiverWallet.value;
    let initCurr = initCurrency.value;
    let targetCurr = targetCurrency.value;
    let amount = exchangeAmount.value;
    let userId = sessionStorage.getItem('userID')
    fetch('/operation/exchange', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            userId: userId,
            senderWalletBlockchainAddress: sender,
            receiverWalletBlockchainAddress: receiver,
            initialCurrency: initCurr,
            targetCurrency: targetCurr,
            transactionAmount: amount
        })
    });
    setTimeout(function () { location.reload(true); }, 200);
});