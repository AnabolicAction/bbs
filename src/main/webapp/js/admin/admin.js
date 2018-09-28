window.onload = function() {
  $("body").on("click", ".userRemove", (function(event) {
    if (confirm("정말 삭제하시겠습니까??") == false) {
      return false;
    }
  }));

  $("body").on("change", "#size", (function(event){
    var type = $("#searchType option:selected").val();
    var value = $("#search").val();
    var size = $("#size option:selected").val();
    location.href="/admin/user/list?size=" + size +"&searchType="+type+"&searchValue="+value;
    })
  );
}