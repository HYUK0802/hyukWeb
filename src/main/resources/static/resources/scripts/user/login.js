const loginForm = document.getElementById('loginForm');
const id = document.getElementById('userid')

loginForm.onsubmit = e => {
    e.preventDefault()
    if (loginForm['userid'].value === '') {
        loginForm['userid'].focus();
        alert('아이디를 입력해주세요')
    }
    if (loginForm['password'].value === '') {
        loginForm['password'].focus();
        alert('비밀번호를 입력해주세요')
    }
    const xhr = new XMLHttpRequest();
    const formData = new FormData();
    xhr.open('POST','/login' );
    xhr.onreadystatechange = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            return;
        }
            if (xhr.status >= 200 && xhr.status < 300 ) {
            const responseObject = JSON.parse(xhr.responseText);
                alert(id)
                switch (responseObject.result){
                case 'failure_id':
                    alert("아이디가 올바르지 않습니다.");
                    loginForm['userid'].focus();
                    loginForm['userid'].select();
                    break;
                case 'failure_pw':
                    alert("비밀번호가 올바르지 않습니다.");
                    loginForm['password'].focus();
                    loginForm['password'].select();
                    break;
                case 'success':
                    location.href ="/"
                    break;
                default:
                    alert('서버오류입니다 재시도 해주세요')
            }
            } else {
                alert('네트워크 오류입니다. 새로고침 후 다시 시도해주세요')
            }
    };
    xhr.send(formData);
}
