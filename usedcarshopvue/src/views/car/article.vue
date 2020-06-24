<template>
  <el-table :data="tableData" style="width: 80%">
    <el-table-column prop="id" label="id" width="180"></el-table-column>
    <el-table-column prop="title" label="标题" width="180"></el-table-column>
    <el-table-column prop="content" label="内容" width="400"></el-table-column>
    <el-table-column prop="gmtCreat" label="创建日期" width="150"></el-table-column>
    <el-table-column width="80">
      <template slot-scope="scope">
        <el-button type="primary" icon="el-icon-edit" circle @click="modifyArticle(scope.row)"></el-button>
      </template>
    </el-table-column>
    <el-table-column width="80">
      <template slot-scope="scope">
        <el-button type="danger" icon="el-icon-delete" circle @click="deleteArticle(scope.row)"></el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

 <script>
import { getRequest } from "@/utils/service";
export default {
  data() {
    return {
      tableData: ""
    };
  },
  mounted: function() {
    getRequest("/article/selectAll").then(res => {
      this.tableData = res.data.data;
    });
  },
  methods: {
    deleteArticle(row) {
      getRequest("/article/deteleOne/" + row.id).then(res => {
        if (res.data.code == 200) {
          this.$message({
            showClose: true,
            message: "删除成功",
            type: "success"
          });
        } else {
          this.$message.error("删除失败");
        }
      });
    }
  }
};
</script>

  <style>
.el-table {
  margin: 50px 50px 50px 50px;
}
</style>