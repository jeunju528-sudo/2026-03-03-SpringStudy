<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.row {
	width: 700px;
	margin: 0px auto;
}
</style>
<script type="text/javascript" src="https://unpkg.com/vue@3/dist/vue.global.js"></script>
</head>
<body>
	<div class="container" id="app">
		<div class="row">
			<h2 class="text-center">자료 등록</h2>
			<form action="../databoard/insert_ok.do" method="post" enctype="multipart/form-data">
				<table class="table">
					<tr>
						<th width="15%" class="text-center success">이름</th>
						<td width="85%">
							<input type="text" name="name" size="20" class="input-sm" required>
						</td>
					</tr>
					<tr>
						<th width="15%" class="text-center success">제목</th>
						<td width="85%">
							<input type="text" name="subject" size="20" class="input-sm" required>
						</td>
					</tr>
					<tr>
						<th width="15%" class="text-center success">내용</th>
						<td width="85%">
							<textarea rows="10" cols="62" name="content" required></textarea>
						</td>
					</tr>
					<tr>
						<th width="15%" class="text-center success">첨부파일</th>
						<td width="85%">
							<table class="table">
								<tr>
									<td class="text-right">
										<button class="btn-xs btn-success" @click="addFile()" type="button">+</button>
										<button class="btn-xs btn-success" @click="removeFile()" type="button">-</button>
									</td>
								</tr>
							</table>
							<table class="table">
								<tbody>
									<tr v-for="(file, index) in files " :key="index">
										<th width="20%">FILE {{index+1}}</th>
										<td width="80%">
											<input type="file" :name="'files['+index+']'">
										</td>
									</tr>
								</tbody>
							</table>
						</td>
					</tr>
					<tr>
						<th width="15%" class="text-center success">비밀번호</th>
						<td width="85%">
							<input type="password" name="pwd" size="20" class="input-sm" required>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center">
							<button type="submit" class="btn-sm btn-primary">등록</button>
							<button type="button" class="btn-sm btn-primary" onclick="javascript:history.back()">취소</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	<script>
		let app = Vue.createApp({
			data(){
				return {
					files:[]
				}
			},
			mounted(){
				
			},
			methods:{
				addFile(){
					this.files.push({
						
					})
				},
				removeFile(){
					if(this.files.length > 0){
						this.files.pop()
					}
					
				}
			}
		}).mount("#app")
	</script>
</body>
</html>