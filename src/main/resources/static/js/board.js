let index = {
	init: function(){
		$("#btn-save").on("click",()=>{
			this.save();
		});
		$("#btn-update").on("click",()=>{
			this.update();
		});
		$("#btn-delete").on("click",()=>{
			this.deleteById();
		});
},		
		save :function(){
			let data = {
				title : $("#title").val(),
				content : $("#content").val()
			}
			console.log(data);
			$.ajax({
				type:"POST",
				url:"/api/board",
				data:JSON.stringify(data),
				contentType:"application/json; charset=utf-8",
				dataType:"json"
			}).done(function(resp){
				alert('글쓰기가 완료되었습니다.');
				location.href="/";
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		},
		update :function(){
			let data = {
				id : $("#id").val(),
				title : $("#title").val(),
				content : $("#content").val()
			}
			$.ajax({
				type: "PUT",
				url:"/api/board/	"+data.id,
				data:JSON.stringify(data),
				contentType:"application/json; charset=utf-8",
				dataType:"json"
			}).done(function(resp){
				alert('글수정이 완료되었습니다.');
				location.href="/";
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		},
		deleteById :function(){
			var id=$("#id").text();
			console.log(id);
			$.ajax({
				type:"DELETE",
				url: "/api/board/"+id,
				data:JSON.stringify(id),
				dataType:"json"
			}).done(function(resp){
				alert('삭제가 완료되었습니다.');
				location.href = "/";
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		}
		}
	
	index.init();