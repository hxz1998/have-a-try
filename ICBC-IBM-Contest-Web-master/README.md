# ICBC-IBM-Contest

![Build:pass](https://img.shields.io/badge/build-pass-green.svg)
![Version:1.0](https://img.shields.io/badge/Version-1.0-brightgreen.svg)
![License:MIT](https://img.shields.io/badge/LICENSE-MIT-blue.svg)
![Spring:4.3.18.RELEASE](https://img.shields.io/badge/Spring-4.3.18.RELEASE-brightgreen.svg)
![Fastjson:1.2.47](https://img.shields.io/badge/fastjson-1.2.47-brightgreen.svg)
![Vue:2.5.16](https://img.shields.io/badge/Vue-2.5.16-brightgreen.svg)
![Vue-resource:1.5.1](https://img.shields.io/badge/Vue--resource-1.5.1-brightgreen.svg)
![Vue-router3.0.1](https://img.shields.io/badge/Vue--router-3.0.1-brightgreen.svg)
![Bootstrap:3.3.7](https://img.shields.io/badge/Bootstrap-3.3.7-brightgreen.svg)
![JQuery:3.3.1](https://img.shields.io/badge/JQuery-3.3.1-brightgreen.svg)
![Vuex:3.0.1](https://img.shields.io/badge/Vuex-3.0.1-brightgreen.svg)

## 项目简介
**该项目旨在使用一种简单的方式为残障人士快速建立金融通道，使他们有机会使用更加方便快捷的服务。** 但同时该应用也适用于普通大众。
> [特别感谢 ICBC及IBM 为该项目提供的API开放接口服务和支持](https://open.icbc.com.cn/icbc/apip/service.html)。
* 注：该项目为前端支持项目

## 后端项目
> [传送门](https://github.com/MonkeyAndDog/ICBCIBMContest)

## 技术栈
**该项目为2018 ICBC - IBM全国大学生金融科技创新大赛使用，具体技术细节及描述如下：**
1. 使用Java语言，SpringMVC框架作为后端语言及工具，接入ICBC开放API服务提供前端支持。
2. 使用Bootstrap框架构建前端页面样式。
3. 使用Vue、Vue-resource、Vue-router框架与后端服务交互。
4. 使用maven对整个项目进行管理和构建。
5. 使用tomcat为服务器容器对应用进行部署。
6. 使用npm管理前端依赖
7. 使用webpack打包前端项目

## 项目源码获取、打包及运行发布
```
git clone git@github.com:MonkeyAndDog/ICBC-IBM-Contest-Web.git
cd ICBC-IBM-Contest-Web
npm install
运行本地示例页面：
npm run dev
编译项目：
npm run build
```

## 完成功能
- [x] 生成二维码

## 效果演示
[戳这里👈](http://118.31.62.78:8080/icbc/)

### 二维码扫码演示：
![](https://github.com/MonkeyAndDog/ICBCIBMContest/blob/master/screenshots/qr.png)

## 部分页面截屏
### 主页
![](https://github.com/MonkeyAndDog/ICBCIBMContest/blob/master/screenshots/home.jpg)

### 应用列表
![](https://github.com/MonkeyAndDog/ICBCIBMContest/blob/master/screenshots/applicationlist.jpg)

### 二维码生成输入组框
![](https://github.com/MonkeyAndDog/ICBCIBMContest/blob/master/screenshots/qr-pay-input.jpg)

### 二维码生成结果
![](https://github.com/MonkeyAndDog/ICBCIBMContest/blob/master/screenshots/qr-pay.jpg)

### 关于页
![](https://github.com/MonkeyAndDog/ICBCIBMContest/blob/master/screenshots/about.jpg)

## LICENSE
[Apache](https://github.com/MonkeyAndDog/ICBC-IBM-Contest-Web/blob/master/LICENSE)
```text
Copyright [HuXiaozhong]

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
