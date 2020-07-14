<template>
  <div>
    <el-row>
      <el-button style="float: right" type="info" @click="newInsert()">添加</el-button>
    </el-row>
    <el-table :data="tableData" style="width: 95%">
      <el-table-column prop="id" label="id"></el-table-column>
      <el-table-column prop="brand_name" label="名称"></el-table-column>
      <el-table-column prop="brand_picture" label="图片"></el-table-column>
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
    <el-dialog title="品牌" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="id" label-width="150px">
          <el-input v-model="form.carId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="名称" label-width="150px">
          <el-input v-model="form.title" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="图片" label-width="150px">
          <el-input v-model="form.content" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="cancel">取 消</el-button>
        <el-button type="primary" @click="commit">确 定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

 <script>
import { getRequest } from "@/api/api";
import { puttRequest } from "@/api/api";
import { postRequest } from "@/api/api";
export default {
  data() {
    return {
      tableData: [''],
      form: {
        id: '',
        b_m_id: '',
        brand_name: '',
        brand_picture: ''
      },
      dialogFormVisible: false
    };
  },
  mounted: function() {
    getRequest("/brand/selectAll").then(res => {
      this.tableData = res.data.data;
    });
  },
  methods: {
    cancel() {
      this.form = this.$options.data().form;
      this.dialogFormVisible = false;
    },
    deleteArticle(data) {
      deleteRequest("/brand/" + data.id).then(res => {
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
    },
    modifyArticle(data) {
      this.form = data;
      this.dialogFormVisible = true;
    },
    newInsert() {
      this.form = this.$options.data().form;
      this.dialogFormVisible = true;
    },
    commit() {
      if (this.form.id !== null && this.form.id !== "") {
        this.upsate();
      } else {
        this.insert();
      }
    },
    insert() {
      postRequest("/brand/insert", this.form).then(res => {
        if (res.data.code == 200) {
          this.$message({
            showClose: true,
            message: "添加成功",
            type: "success"
          });
          this.dialogFormVisible = false;
          getRequest("/article/selectAll").then(res => {
            this.tableData = res.data.data;
          });
        } else {
          this.$message.error("添加失败");
        }
      });
    },
    upsate() {
      putRequest("/brand/update", this.form).then(res => {
        if (res.data.code == 200) {
          this.$message({
            showClose: true,
            message: "修改成功",
            type: "success"
          });
          this.dialogFormVisible = false;
        } else {
          this.$message.error("修改失败");
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