var stompClient;
const currentUserId = '2'
const recipientId = '1'

function send() {
    let message = document.getElementById("message").value;
    sendMessage(message)
    var ul = document.getElementById("messages");
    var li = document.createElement("li");
    li.appendChild(document.createTextNode("You: " + message));
    ul.appendChild(li);
    document.getElementById("message").value = '';
}

const sendMessage = (msg) => {
    if (msg.trim() !== "") {
        const message = {
            senderId: currentUserId,
            recipientId: recipientId,
            message: msg,
            date: new Date(),
        };

        stompClient.send("/webSocketApp/chat", {}, JSON.stringify(message));
    }
};

function connect() {
    SockJS = new SockJS("http://localhost:8080/ws");
    stompClient = Stomp.over(SockJS);
    stompClient.connect({}, onConnected, onError);
}

function onMessageReceived(message) {
    var ul = document.getElementById("messages");
    var li = document.createElement("li");
    li.appendChild(document.createTextNode("Friend: " + JSON.parse(message.body).message));
    ul.appendChild(li);
}

function onError() {
    console.log("error during connection")
}

function onConnected() {
    document.getElementById("connectionDiv").setAttribute("style", "visibility: hidden;")
    document.getElementById("chat-div").setAttribute("style", "visibility: visible;")

    stompClient.subscribe(
        "/user/" + currentUserId + "/queue/messages",
        onMessageReceived
    );
}
