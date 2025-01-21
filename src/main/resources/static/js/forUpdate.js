function idForUpdate() {
    // 비밀번호 확인 없이 그냥 페이지 리디렉션
    window.location.href = '/user/idForUpdate';  // 아이디 확인 페이지로 이동
}


// DOMContentLoaded 이벤트를 사용하여 DOM이 완전히 로드된 후 실행
document.addEventListener('DOMContentLoaded', () => {
    window.checkId = function () {
        const userIdElement = document.getElementById('userId');

        // DOM 요소가 존재하는지 확인
        if (!userIdElement) {
            alert('아이디 입력 필드가 없습니다.');
            return;
        }

        const userId = userIdElement.value;

        if (!userId) {
            alert('아이디를 입력해 주세요.');
            return;
        }

        // AJAX 요청
        $.ajax({
            type: 'POST',
            url: '/user/check-before-update',
            data: JSON.stringify({ userId: userId }),
            contentType: 'application/json',
            success: function () {
                // 서버가 응답을 성공적으로 반환하면 폼 생성 후 전송
                const form = document.createElement('form');
                form.method = 'POST';
                form.action = '/user/nicknameUpdate';

                const hiddenInput = document.createElement('input');
                hiddenInput.type = 'hidden';
                hiddenInput.name = 'userId';
                hiddenInput.value = userId;

                form.appendChild(hiddenInput);
                document.body.appendChild(form);
                form.submit();
            },
            error: function () {
                alert('아이디가 올바르지 않습니다. 다시 시도해 주세요.');
            }
        });
    };
});




function updateNickname() {
    const newNickname = document.getElementById('new-nickname').value;
    const userId = document.getElementById('user-id').value;  //

    if (!newNickname) {
        alert('새 닉네임을 입력해 주세요.');
        return;
    }

    $.ajax({
        type: 'PATCH',
        url: '/user/update-nickname',
        data: JSON.stringify({
            userId: userId,
            newNickname: newNickname
        }),
        contentType: 'application/json',
        success: function(response) {
            alert('닉네임이 성공적으로 변경되었습니다!');
            window.location.href = '/mypage';  // 변경된 페이지로 리디렉션
        },
        error: function(error) {
            alert('닉네임 변경에 실패했습니다. 다시 시도해 주세요.');
        }
    });
}
