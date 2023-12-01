<template>
  <div style="height: 100%">
    <el-container style="min-height: 100vh; border: 1px solid #eee">
      <el-aside :width="sideWidth + 'px'" style="background-color: rgb(45,113,220);" >
        <el-menu :default-openeds="['1', '3']" style="min-height: 100%"
                 background-color="rgb(48, 65, 86)"
                 text-color="fff"
                 active-text-color="#ffffff"
                 :collapse-transition="false"
                 :collapse="isCollapse"
        >
          <div style="height: 60px; line-height: 60px; text-align: center">
            <img src="../assets/logo.png" alt="" style="width: 20px; position: relative; top: 5px; margin-right: 5px">
            <b style="color: white" v-show="logoTextShow">商品管理系统</b>
          </div>
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>
              <span slot="title" style="color: rgb(250,249,249)">导航一</span>
            </template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>

        </el-menu>
      </el-aside>

      <el-container>
        <el-header style="font-size: 12px; border-bottom: 1px solid #ccc; line-height: 60px; display: flex">
          <div style="flex: 1; font-size: 18px; display: flex; flex-direction:row; height: auto; align-items: center;">
            <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>
            <el-breadcrumb separator="/" style="margin: 2%">
              <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
              <el-breadcrumb-item><a href="/">活动管理</a></el-breadcrumb-item>
            </el-breadcrumb>
          </div>
          <el-dropdown style="width: 50px; cursor: pointer">
            <span>王小虎</span><i class="el-icon-arrow-down" style="margin-left: 5px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>个人信息</el-dropdown-item>
              <el-dropdown-item>退出</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </el-header>

        <el-main>
          <div style="padding: 10px 0; display: flex; flex-direction:row;">
            <el-input v-model="client_name" style="width: 175px" placeholder="请输入姓名" suffix-icon="el-icon-search" class="mr-5"></el-input>
<!--            <el-input v-model="Email" style="width: 200px" placeholder="请输入邮箱" suffix-icon="el-icon-search" class="mr-5"></el-input>-->
<!--            <el-input v-model="Address" style="width: 200px" placeholder="请输入地址" suffix-icon="el-icon-search" class="mr-5"></el-input>-->
            <el-button style="width: 70px" class="ml-5" type="primary" @click="load" icon="el-icon-search">搜索</el-button>
          </div>
          <div style="margin-bottom: 5px">
            <el-button type="primary">新增 <i class="el-icon-circle-plus-outline"></i></el-button>
            <el-button type="danger">批量删除 <i class="el-icon-remove-outline"></i></el-button>
            <el-button type="primary">导入 <i class="el-icon-bottom"></i></el-button>
            <el-button type="primary">导出 <i class="el-icon-top"></i></el-button>
          </div>
          <el-table :data="tableData" border stripe header-cell-class-name="headerBg">
            <el-table-column prop="client_id" width="140">
              <template slot="header" scope="scope">
                <span style="color: #ffffff;">用户名</span>
              </template>
            </el-table-column>
            <el-table-column prop="client_name" width="120">
              <template slot="header" scope="scope">
                <span style="color: #ffffff;">姓名</span>
              </template>
            </el-table-column>
            <el-table-column prop="client_mobile">
              <template slot="header" scope="scope">
                <span style="color: #ffffff;">电话</span>
              </template>
            </el-table-column>
            <el-table-column>
              <template slot-scope="scope">
                <el-button type="warning" style="margin-left: 67%">编辑</el-button>
                <el-button type="danger">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <div style="padding: 10px 0">
            <el-pagination
                @size-change="handleSizeChange"
                @current-change="handleCurrentChange"
                :current-page="pageNum"
                :page-sizes="[2, 5, 10, 20]"
                :page-size="pageSize"
                layout="total, sizes, prev, pager, next, jumper"
                :total="total">
            </el-pagination>
          </div>
        </el-main>
      </el-container>
    </el-container>

  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'HomeView',
  data(){
    console.log(this)
    return {
      tableData: [],
      total: 0,
      pageNum: 1,
      pageSize: 2,
      client_name: "",
      msg: "tmd",
      collapseBtnClass: 'el-icon-s-fold',
      isCollapse: false,
      sideWidth: 200,
      logoTextShow: true,
    }
  },
  created() {
    //请求分页查询数据
    this.load()
  },
  methods: {
    collapse() {// 点击收缩按钮触发
      this.isCollapse = !this.isCollapse;
      if(this.isCollapse) {
        this.sideWidth = 64
        this.collapseBtnClass = 'el-icon-s-unfold'
        this.logoTextShow = false
      }else {
        this.sideWidth = 200
        this.collapseBtnClass = 'el-icon-s-fold'
        this.logoTextShow = true
      }
    },
    load() {
      fetch("http://localhost:9090/client/page?pageNum=" + this.pageNum + "&pageSize=" + this.pageSize + "&client_name=" + this.client_name)
          .then(res => {
            if (!res.ok) {
              throw new Error('网络响应不是ok');
            }
            return res.json();
          })
          .then(res => {
            console.log(res);
            this.tableData = res.data;
            this.total = res.total;
          })
          .catch(error => {
            console.error('fetch 操作出现问题:', error);
          });
    },
    handleSizeChange(pageSize) {
      console.log(pageSize)
      this.pageSize = pageSize
      this.load()
    },
    handleCurrentChange(pageNum) {
      console.log(pageNum)
      this.pageNum = pageNum
      this.load()
    }
  }
}
</script>
<style>
.headerBg{
  background: #42b983!important;
}
</style>