function promiseAjax(type, url, data) {
  // $.blockUI({
  //     message:"<img src=""></img>",
  //     css: {borderWidth: '0px', backgroundColor: 'transparent'}
  // });
  return new Promise(function (resolve, reject) {
    $("#chkField").val("");
    let res = null;
    let header;
    let sendData = data;
    if (type === 'post') {
      // if (isEmpty(data)) {
      sendData = JSON.stringify(data);
      // }
      header = {
        "Accept": "application/json; charset=UTF-8",
        "Content-type": "application/json; charset=UTF-8"
      }
    }
    $.ajax({
      type: type,
      headers: header,
      data: sendData,
      url: pageContext + url,
      cache: false,
      timeout: 600000,
      async: true,
      success: function (response) {
        if(response.code === 0){
          $("#chkField").val("ok");
          resolve(response.data);
        }else{
          alert(response.msg);
          $("#chkField").val("error");
        }
      },
      error: function (e) {
      },
      statusCode: {
        401: function () {
        }
      }
    });
  });
}