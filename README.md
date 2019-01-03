# block
区块链电子证据保全项目(个人开发中，未完待续)
参考网址： https://ybear-web.com/index
个人博客： https://blog.csdn.net/qq_24407053


页面截图及效果参考：

 https://blog.csdn.net/qq_24407053/article/details/85618314

开发环境：
1. JDK1.8
2. Maven
3. Spring Boot + SpringMVC + Mybatis
4. Spring Security + Spring Social + Spring OAuth
5. Bubi SDK
6. web3j
7. EVM
8. docker

---

目标： 
1. 提供基于Spring Security 的安全网站
2. 提供常规登录模式以及第三方登录
3. 基于布比区块链完成数据模块的搭建，保证证据信息上链
4. 基于web3j实现对以太坊的链上代码调用
5. 基于配置选择布比或者以太坊进行数据上链服务
5. 对于热点数据采用Redis进行保存
6. 尽力完成基于证据链的系统开发

运行方法：
1. 无需更改源码，以maven工程导入
2. 安装docker,并在命令行中运行
```
docker run -d --name ethereum -p 8545:8545 -p 30303:30303 ethereum/client-go --rpc --rpcaddr "0.0.0.0" --rpcapi="db,eth,net,web3,personal" --rpccorsdomain "*" --dev
```
3. 运行springboot项目
4. 账户user 密码：123456（目前没有集成数据库，是写死的，不能注册）
5. .../user进入功能页面，提供存证和查证功能
