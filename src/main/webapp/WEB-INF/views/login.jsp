<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<div class="login-box">
	<div class="login-logo">
		<a href="/"><b>BBS</b> PROJECT</a>
	</div>
	<div class="login-box-body">
		<p class="login-box-msg">Please Input ID/Password</p>
		<form action="/login" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<div class="form-group has-feedback">
				<input type="text" name="id" class="form-control" placeholder="ID" />
			</div>
			<div class="form-group has-feedback">
				<input type="password" name="password" class="form-control" placeholder="Password" />
			</div>
			<div class="row">
				<div class="col-xs-8"></div>
				<div class="col-xs-4">
					<button type="submit" class="btn btn-primary btn-block btn-flat">Login</button>
				</div>
			</div>
		</form>
	</div>
</div>