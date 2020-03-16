路径：href,src

格式： @{  }

eg:   

<link rel="stylesheet" th:href="@{/css/admin.less}" />

<script th:src="@{/js/jquery-3.2.1.min.js}"></script>
一般项目默认static就是根路径，所以static下的路径中不能写static，应当以 / 代替
