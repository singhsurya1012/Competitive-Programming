/*
function myFunction() {
    alert("Inside myFunction");

    if(ws=null) {
        setConnected(false);
    }
}
 */


function connect() {
    console.log("Inside connect")
    ws = new WebSocket('ws://localhost:8080/name'); 
    //ws = new WebSocket("ws://localhost:7001/SimpleSpringBootWebSocket/name");
    console.log("Connected");
    console.log(ws);
    
    ws.onopen = function(event) {
        onOpen(event.data)
    };

    ws.onmessage = function(event){
        console.log("onMessage")
        onMessage(event.data);
    //  return false;
    }
    setConnected(true);

}

function disconnect() {
    console.log("Inside disconnect")
    if (ws != null) {
        ws.close();
    }
    setConnected(false);
    console.log("Disconnected");
}


function setConnected(x) {
    console.log("Inside setConnected")
    document.getElementById("connect").disabled = x;
    document.getElementById("disconnect").disabled = !x
    document.getElementById("fieldset").disabled = !x
}

function send() {
    console.log("Inside send")
    var userInput = document.getElementById("name").value;

    console.log(document.getElementById("name").value);
    ws.send(userInput);
    document.getElementById("name").value = null;
}

function onOpen(x) {
    console.log(x);
}

function onMessage(message) {
    
    console.log(message)
    document.getElementById("msg").innerHTML +=  message  + "<br>" ;
    //msg = msg + message.data;
}