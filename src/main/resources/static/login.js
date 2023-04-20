let form = document.querySelector('form');
form.addEventListener('submit',(e) => {
    event.preventDefault();
    fetch(event.target.action, {
        method: 'get',
        body: new URLSearchParams(new FormData(event.target)) // event.target is the form
    }).then((response) => {
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        return response.json(); // or response.text() or whatever the server sends
    }).then((body) => {
        document.location.href = '/index.html'
    }).catch((error) => {
        // TODO handle error
    });
});