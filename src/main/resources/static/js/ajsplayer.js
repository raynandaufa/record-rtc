var videofilename = GetURLParameter('filename');

    function GetURLParameter(sParam)
    {
      var sPageURL = window.location.search.substring(1);
      var sURLVariables = sPageURL.split('&');
      for (var i = 0; i < sURLVariables.length; i++)
        {
          var sParameterName = sURLVariables[i].split('=');
          if (sParameterName[0] == sParam)
          {
            return sParameterName[1];
          }   
        }
      }

      var video = document.getElementById('my-video');
      var source = document.createElement('source');

      source.setAttribute('src', 'http://paymentcc.sinarmasmsiglife.co.id:9888/upload/api/json/stream?lus_id=1&path_id=27&subFolder=' + videofilename);

      video.appendChild(source);