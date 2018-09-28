<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
	<%--<script src="/ckeditor/ckeditor.js"></script>--%>
	<script src="/js/jQuery-2.1.4.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/icheck.min.js" ></script>

    <meta charset="UTF-8">
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <link href="/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="/css/AdminLTE.min.css" rel="stylesheet" type="text/css"/>
    <link href="/css/blue.css" rel="stylesheet" type="text/css" />
    <link href="/css/_all-skins.min.css" rel="stylesheet" type="text/css"/>
    <link href="/css/style.css" rel="stylesheet" type="text/css"/>
</head>
<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>
<body class="skin-blue sidebar-mini">
	<div class="wrapper">
		<div class="content-wrapper">
			<section class="content">
				<div class="col-md-2"></div>
				<div class="row">
					<div class="col-md-8">
						<tiles:insertAttribute name="body" />
					</div>
				</div>
				<div class="col-md-2"></div>
			</section>
		</div>
	</div>
</body>
</html>