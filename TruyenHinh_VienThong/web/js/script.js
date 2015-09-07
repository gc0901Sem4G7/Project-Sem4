$(document).ready(function() {
    $("#btnChapNhan").click(function() {
        var indexMienDat = document.getElementById("mienDat").selectedIndex;
        
        var mienDat = document.getElementsByTagName("option")[indexMienDat].value;
        
        if (mienDat == "luaChon") {
            alert("Ban chua chon miền nào để đăng ký.")
            return false;
        }
        
        $("#mienDatAn").val(mienDat);
        $("#mienDatForm").submit();
    });
    
    $("a.dangKy").click(function() {
        var indexMienDat = document.getElementById("mienDat").selectedIndex;
        var mienDat = document.getElementsByTagName("option")[indexMienDat].value;
        
        if (mienDat == "luaChon") {
            alert("Ban chua chon miền nào để đăng ký.")
            return false;
        }

    });
    
    $("#btn-dang-ky").click(function() {
        var username = $("#username").val();
        var password = $("#password").val();
        var name = $("#name").val();
        var cardId = $("#card_id").val();
        var phoneName = $("#phone_number").val();
        var address = $("#address").val();
        var packageId = $("#package_id").val();
        var dealerId = $("#dealer_id").val();
        
        if (username == "") {
            alert("You haven't fill username yet!");
            return;
        } else if (password == "") {
            alert("You haven't fill password yet!");
            return;
        } else if (name == "") {
            alert("You haven't fill name yet!");
            return;
        } else if (cardId == "") {
            alert("You haven't fill card Id yet!");
            return;
        } else if (phoneName == "") {
            alert("You haven't fill phone number yet!");
            return;
        } else if (address == "") {
            alert("You haven't fill address yet!");
            return;
        } else if (packageId == "") {
            alert("You haven't fill package Id yet!");
            return;
        } else if (dealerId == "") {
            alert("You haven't fill dealer Id yet!");
            return;
        }
    });
});

