<template>
  <div>
    <el-row>
      <el-button style="float: right" type="info" @click="newInsert()">添加</el-button>
    </el-row>
    <el-table :data="tableData" style="width: 95%">
      <el-table-column prop="title" label="标题"></el-table-column>
      <el-table-column prop="content" label="内容"></el-table-column>
      <el-table-column prop="gmtCreat" label="创建日期"></el-table-column>
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
    <el-dialog title="信息" :visible.sync="dialogFormVisible">
      <el-form :model="form">
        <el-form-item label="汽车id" label-width="150px">
          <el-input v-model="form.carId" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="标题" label-width="150px">
          <el-input v-model="form.title" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="内容" label-width="150px">
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
import { deleteRequest } from "@/api/api";
import { postRequest } from "@/api/api";
import { putRequest } from "@/api/api";
export default {
  data() {
    return {
      dialogFormVisible: false,
      tableData: [''],
      form: {
        id: '',
        carId: '',
        title: '',
        content: '',
        viewCount: ''
      }
    };
  },
  mounted: function() {
    getRequest("/article/selectAll").then(res => {
      this.tableData = res.data.data;
    });
  },
  methods: {
    deleteArticle(data) {
      deleteRequest("/article/" + data.id).then(res => {
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
    cancel() {
      this.form = this.$options.data().form;
      this.dialogFormVisible = false;
    },
    modifyArticle(data) {
      this.dialogFormVisible = true;
      this.form = data;
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
      postRequest("/article/insert", this.form).then(res => {
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
      getRequest("/article/selectAll").then(res => {
        this.tableData = res.data.data;
      });
    },
    upsate() {
      putRequest("/article/update", this.form).then(res => {
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