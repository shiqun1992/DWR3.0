<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <meta charset="utf-8" />
  <title></title>

  <script src="<%=request.getContextPath()%>/dwr/engine.js"></script>
  <script src="<%=request.getContextPath()%>/dwr/util.js"></script>
  <script src="<%=request.getContextPath()%>/dwr/interface/Hello.js"></script>
  <script src="<%=request.getContextPath()%>/dwr/interface/ConstructBinaryTree.js"></script>

  <style>
    .top{width:500px;height: 500px;margin:0 auto;}
    div{border:1px solid #a9c9e2;background:#e8f5fe}
  </style>

  <script>
      Hello.sayHello("shiqun");
      function get()
      {
          //alert("2222");
          var dlr = document.getElementById("dlr").value;
          var ldr = document.getElementById("ldr").value;
          ConstructBinaryTree.invoke(dlr,ldr,result);
      }

      function result(data)
      {
          alert(data);
          document.getElementById("tree").value = data;
          return;
      }
  </script>

</head>
<body>
<div class="top">
  <div class="topic">
    <div class="name">
      1. 题目描述
    </div>
    <div class="description">
      输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
      例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6};
    </div>

    <div class="result">
      <table>
        <tr>
          <th>前序遍历结果</th>
          <th><input type="text" size="50" id = "dlr"/></th>
        </tr>

        <tr>
          <th>中序遍历结果</th>
          <th><input type="text" size="50" id = "ldr"/></th>
        </tr>

        <tr>
          <th><input type="button" value="原始二叉树为" onclick="get();"/> </th>
          <th><input type="text" size="50" id="tree"/></th>
        </tr>

      </table>
    </div>

  </div>
</div>
</body>
</html>
