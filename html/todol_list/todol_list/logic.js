let button = document.querySelector(".create-button")
// a variavel button recebe o document para o botao
console.log(button)
//agora adicionamos um evente, que ao efectuar o enveto click, acontece alguma acao 
button.addEventListener("click", ()=> {
    //alert("mensagem");
    //para aparecer uma mensagem de alerta

    let input = document.querySelector(".new-task-input");
    //alert(input.value);
    let task = `
        <div class="task">
            <div class="left-container">
                <input type="checkbox" class="checkbox">
                <span class="task-text">${input.value}</span>
            </div>
            <div class="right-container">
                <span class="fa fa-trash"></span>
            </div>
        </div>
    `;
    let tasksContainer = document.querySelector(".cards");
    tasksContainer.innerHTML += task;
})