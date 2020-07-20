<template>
  <div>
    <el-row>
      <el-button style="float: right" type="info" @click="newInsert()">添加</el-button>
    </el-row>
    <el-table :data="tableData" style="width: 80%">
      <el-table-column prop="date" label="日期" ></el-table-column>
      <el-table-column prop="name" label="姓名" ></el-table-column>
      <el-table-column prop="address" label="地址"></el-table-column>
      <el-table-column width="50px">
        <template slot-scope="scope">
          <el-button type="primary" icon="el-icon-edit" circle @click="modifyArticle(scope.row)"></el-button>
        </template>
      </el-table-column>
      <el-table-column width="50px">
        <template slot-scope="scope">
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteArticle(scope.row)"></el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

 <script>
export default {
  data() {
    return {
      tableData: {
        date: "",
        name: "",
        address: ""
      }
    };
  },
  mounted: function(){
    console.log(this.$route.path)
  }
};
</script>

  <style>
.el-table {
  margin: 50px 50px 50px 50px;
}
</style>