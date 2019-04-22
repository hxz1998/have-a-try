<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />
    <title></title>
    <script src="js/mui.min.js"></script>
    <link href="css/mui.min.css" rel="stylesheet"/>
    <script type="text/javascript" charset="utf-8">
      	mui.init();
    </script>
</head>
<body>
	<div class="mui-content">
	    <?php
		$servername = "101.200.56.88";
		$username = "Hu";
		$password = "tiger";
		$DB = "learning2";
		// 创建连接
		$conn = new mysqli($servername, $username, $password, $DB);
		// 检测连接
		if ($conn->connect_error) {
		    
		} else{
		}
		/*
		 * 下面这个注释非常重要，重要到你难以想象。
		 */
		mysqli_query($conn, "SET NAMES 'UTF8'");
		
		$sql = "SELECT id, name, title, cont, artdate FROM employee order by id";
		$result = $conn->query($sql);
		
		if ($result->num_rows > 0) {
		    // 输出每行数据
		    while($row = $result->fetch_assoc()) {
		    	
		    	echo "<ul class='mui-table-view'>
					    <li class='mui-table-view-cell mui-collapse'>
					        <a class='mui-navigate-right' href='#'>".$row['title']."</a>
					        <div class='mui-collapse-content'>
					            <p>
								<div class='mui-card'>
									<!--页眉，放置标题-->
									<div class='mui-card-header'>".$row['title']."</div>
									<!--内容区-->
									<div class='mui-card-content'> 
										<ul class='mui-table-view'>
										    <li class='mui-table-view-cell mui-media'>
										        <div class='mui-media-body'>
	
												".$row['cont']."
												</div>
										
											</li>
										</ul>			
									</div>
									<!--页脚，放置补充信息或支持的操作-->
									<div class='mui-card-footer'>文章号：<span class='mui-badge mui-badge-primary'>".$row['id']."<span>--------时间：".$row['artdate']."</div>
								</div>
								</p>
					        </div>
					    </li>
					</ul>";
		    }
		} else {
		    echo "0 results";
		}
		$conn->close();
		?>
	</div>
</body>
</html>