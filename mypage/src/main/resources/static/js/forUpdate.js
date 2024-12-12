function idForUpdate() {
    // 비밀번호 확인 없이 그냥 페이지 리디렉션
    window.location.href = '/user/idForUpdate';  // 아이디 확인 페이지로 이동
}


function checkId() {
    const id = document.getElementById('id').value;
    const userId = document.getElementById('userId').value;

    if (!id || !userId) {
        alert('아이디와 사용자 아이디를 입력해 주세요.');
        return;
    }

    // 아이디확인
    $.ajax({
        type: 'POST',
        url: '/user/check-before-update',
        data: JSON.stringify({ id: id, userId: userId }),  // 서버에 아이디 전송
        contentType: 'application/json',
        success: function() {
            // 비밀번호 확인이 성공하면 닉네임 수정 페이지로 이동
            window.location.href = '/user/nicknameUpdate';
        },
        error: function(error) {
            alert('아이디가 올바르지 않습니다. 다시 시도해 주세요.');
        }
    });
}


function updateNickname() {
    const newNickname = document.getElementById('new-nickname').value;

    if (!newNickname) {
        alert('새 닉네임을 입력해 주세요.');
        return;
    }

    $.ajax({
        type: 'PATCH',
        url: '/user/update-nickname',
        data: JSON.stringify({
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
