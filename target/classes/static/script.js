function loadKnowledge() {
    fetch('/api/knowledge')
        .then(response => response.json())
        .then(data => {
            const list = document.getElementById('knowledgeList');
            list.innerHTML = '';

            data.forEach(item => {
                const div = document.createElement('div');

                div.innerHTML = `
                    <h3>${item.title}</h3>
                    <p>${item.content}</p>
                    <small>Category: ${item.category}</small><br><br>
                    <button onclick="deleteKnowledge(${item.id})">Delete</button>
                    <hr>
                `;

                list.appendChild(div);
            });
        });
}

function addKnowledge() {
    const title = document.getElementById('title').value;
    const content = document.getElementById('content').value;
    const category = document.getElementById('category').value;

    fetch('/api/knowledge', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            title: title,
            content: content,
            category: category,
            locked: false
        })
    })
    .then(() => {
        document.getElementById('title').value = '';
        document.getElementById('content').value = '';
        document.getElementById('category').value = '';
        loadKnowledge();
    });
}

function deleteKnowledge(id) {
    fetch(`/api/knowledge/${id}`, {
        method: 'DELETE'
    })
    .then(() => loadKnowledge());
}

window.onload = loadKnowledge;
