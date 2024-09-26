const registerForm = document.getElementById('registerForm');
const checkBtn = document.getElementById('checkId')

registerForm.onsubmit = e => {
    e.preventDefault(); // 폼 제출 중지

    const formData = new FormData(); // FormData 생성
    formData.append('userid', registerForm['userid'].value);
    formData.append('password', registerForm['password'].value);
    formData.append('name', registerForm['name'].value);
    formData.append('age', registerForm['age'].value);

    const xhr = new XMLHttpRequest();
    xhr.open('POST', '/register'); // POST 요청

    // 서버 응답을 처리하는 부분
    xhr.onreadystatechange = () => {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status >= 200 && xhr.status < 300) {
                const responseObject = JSON.parse(xhr.responseText); // 응답 처리
                switch (responseObject.result) {
                    case 'failure':
                        alert('알 수 없는 이유로 가입하지 못했습니다. 다시 시도해주세요.');
                        break;
                    case 'failure_duplicate_id':
                        alert('해당 아이디는 사용 중입니다.');
                        break;
                    case 'success':
                        alert('회원가입 성공!');
                        location.href = "/login"; // 성공 시 로그인 페이지로 이동
                        break;
                    default:
                        alert('서버 오류입니다. 재시도 해주세요.');
                }
            } else {
                alert('네트워크 오류');
            }
        }
    };

    xhr.send(formData); // 서버로 폼 데이터 전송
};
