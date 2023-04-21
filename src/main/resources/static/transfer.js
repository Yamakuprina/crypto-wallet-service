let form = document.querySelector('form');

let senderWallet = document.getElementById("sender-wallet");
let receiverWallet = document.getElementById("receiver-wallet");
let transferCurrency = document.getElementById("currency");
let transferAmount = document.getElementById("transaction-amount");

form.addEventListener('submit', (e) => {
    e.preventDefault();
    let sender = senderWallet.value;
    let receiver = receiverWallet.value;
    let trCurrency = transferCurrency.value;
    let amount = transferAmount.value;
    let userId = sessionStorage.getItem('userID')
    fetch('/operation/transfer', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            userId: userId,
            senderWalletBlockchainAddress: sender,
            receiverWalletBlockchainAddress: receiver,
            currency: trCurrency,
            transactionAmount: amount
        })
    });
    setTimeout(function () { location.reload(true); }, 200);
});