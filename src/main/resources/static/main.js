let registerButton = document.getElementById("register");

if (registerButton != null) {
    registerButton.addEventListener('click', function() {
        let email = document.getElementById("email").value;
        let locationSelect = document.getElementById("location");
        let location = locationSelect.options[locationSelect.selectedIndex].value;
        let timeSelect = document.getElementById("reservedTime");
        let reservedTime = timeSelect.options[timeSelect.selectedIndex].value;

        fetch("/v1/api/member", {
            method: "POST",
            body: JSON.stringify({ email, location, reservedTime }),
            headers: {
                "Content-Type": "application/json"
            }
        })
        .then()
        .then(data => {
            alert("이메일을 등록하였습니다.");
        })
        .catch(error => {
            alert(error);
        });
    });
}