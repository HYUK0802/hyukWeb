const registerForm = document.getElementById('registerForm');
const formData = new FormData();
formData.append('id',registerForm['userId'].value);
formData.append('password',registerForm['password'].value);
formData.append('name',registerForm['name'].value);
formData.append('age',registerForm['age'].value);

registerForm.onsubmit = e => {
    e.preventDefault()
    const xhr = new XMLHttpRequest();
    xhr.open('POST','/register' );
    xhr.onreadystatechange = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status >= 200 && xhr.status < 300 ) {
                const responseObject = JSON.parse(xhr.responseText);
                switch (responseObject.result) {
                    case 'failure':
                        alert('알 수 없는 이유로 가입하지 못했습니다. 다시 시도해주세요')
                        break;
                    case 'failure_duplicate_id':
                        alert('해당 아이디는 사용중입니다.')
                        break;
                    case 'success':
                        alert('회원가입 성공')
                        break;
                    default:
                        alert('서버 오류입니다. 재시도 해주세요')
                }
            } else {
                alert('네트워크 오류')
            }
        }
    };
    xhr.send(formData);
}


