-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: graduation_project
-- ------------------------------------------------------
-- Server version	8.0.22

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `admin_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin','admin','admin'),(2,'pwd123','pwd123','admin','pwd123');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apply_merchant`
--

DROP TABLE IF EXISTS `apply_merchant`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apply_merchant` (
  `id` int NOT NULL AUTO_INCREMENT,
  `apply_id` varchar(45) DEFAULT NULL,
  `account` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `merchant_id` varchar(45) DEFAULT NULL,
  `merchant_name` varchar(45) DEFAULT NULL,
  `merchant_email` varchar(45) DEFAULT NULL,
  `apply_info` varchar(45) DEFAULT NULL,
  `apply_date` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apply_merchant`
--

LOCK TABLES `apply_merchant` WRITE;
/*!40000 ALTER TABLE `apply_merchant` DISABLE KEYS */;
INSERT INTO `apply_merchant` VALUES (13,'apply20210322184201549','ka123','ka123','mer20210322184201548','黑猫探戈','1624197122@qq.com','书店','2021-03-22 18:42:01','Yes'),(14,'apply20210322184248180','Sheng123','Sheng123','mer20210322184248180','各屋苑书店','KaTsuNo123@qq.com','书店','2021-03-22 18:42:48','Yes'),(15,'apply20210322184325796','tk123','tk123','mer20210322184325796','犬山书店','inuyama@google.com','书店','2021-03-22 18:43:25','Yes'),(16,'apply202103221843584','lo123','lo123','mer202103221843584','折尾书店','lo123@163.com','111','2021-03-22 18:43:58','Yes'),(17,'apply20210421211319186','tiao123','tiao123','mer20210421211319186','tiao123','tiao@163.com','123','2021-04-21 21:13:19','Yes'),(18,'apply2021061108001438','aoe123','aoe123','mer2021061108001438','食品店','aaoe@163.com','','2021-06-11 08:00:14','Yes'),(19,'apply20210614202835274','Wiki','123','mer20210614202835273','123','hele@qq.com','sss','2021-06-14 20:28:35','Yes');
/*!40000 ALTER TABLE `apply_merchant` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booktype`
--

DROP TABLE IF EXISTS `booktype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booktype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booktype`
--

LOCK TABLES `booktype` WRITE;
/*!40000 ALTER TABLE `booktype` DISABLE KEYS */;
/*!40000 ALTER TABLE `booktype` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_type`
--

DROP TABLE IF EXISTS `category_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(45) DEFAULT NULL,
  `category_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_type`
--

LOCK TABLES `category_type` WRITE;
/*!40000 ALTER TABLE `category_type` DISABLE KEYS */;
INSERT INTO `category_type` VALUES (1,'图书','学习'),(2,'图书','科幻'),(3,'图书','悬疑'),(4,'图书','散文'),(5,'图书','纪实'),(6,'图书','小说'),(7,'图书','文学'),(8,'图书','传记'),(9,'图书','惊悚'),(14,'图书','绘本'),(15,'图书','科普百科'),(16,'图书','儿童文学'),(17,'图书','幼儿启蒙'),(18,'图书','动漫卡通'),(19,'图书','少儿英语'),(20,'图书','益智游戏'),(21,'图书','中小教辅'),(22,'图书','外语学习'),(23,'图书','考试'),(24,'图书','教材'),(25,'图书','字典词典'),(26,'图书','课外读物'),(27,'图书','字帖'),(28,'图书','考研'),(29,'图书','初级会计'),(30,'图书','教师资格'),(31,'图书','二建'),(32,'图书','四六级'),(33,'图书','政治军事'),(34,'图书','国学古籍'),(37,'图书','心理'),(38,'图书','哲学宗教'),(39,'图书','社会科学'),(40,'图书','文化'),(41,'图书','法律'),(42,'图书','心灵鸡汤'),(43,'图书','社交'),(44,'图书','口才'),(45,'图书','管理'),(46,'图书','经济'),(47,'图书','投资'),(48,'图书','会计'),(49,'图书','营销'),(50,'图书','美食'),(51,'图书','家居'),(52,'图书','体育'),(53,'图书','健身保健'),(54,'图书','美妆'),(55,'图书','旅游地图'),(56,'图书','绘画'),(57,'图书','书法'),(58,'图书','摄影'),(59,'图书','音乐'),(60,'图书','设计'),(61,'图书','科普'),(62,'图书','工业'),(63,'图书','建筑'),(64,'图书','医学'),(65,'图书','电子'),(66,'图书','编程语言'),(67,'图书','计算机安全'),(68,'图书','人工智能'),(69,'图书','操作系统'),(70,'图书','数据库'),(71,'图书','英文原版'),(72,'图书','日语原版'),(74,'图书','计算机'),(75,'服装风格','中式'),(76,NULL,NULL),(77,NULL,NULL),(78,NULL,'1'),(80,'服装品牌','李宁'),(81,'服装季节','春季'),(82,'服装季节','夏季'),(83,'服装季节','秋季'),(84,'服装季节','冬季'),(87,'服装类型','休闲装'),(88,'服装类型','户外装'),(91,'适用人群','老年人'),(92,'适用人群','青少年'),(93,'适用人群','儿童'),(94,'服装风格','日风'),(95,'服装风格','朋克'),(96,'服装风格','中国风 '),(97,'服装风格','英伦'),(98,'服装风格','复古'),(99,'服装风格','巴洛克'),(100,'服装风格','嘻哈'),(101,'服装类型','衬衫'),(118,'手机品牌','华为'),(119,'手机品牌','小米'),(120,'手机品牌','OPPO'),(121,'手机品牌','VIVO'),(125,'家具房间','客厅'),(126,'家具房间','卧室'),(127,'家具房间','厨房'),(128,'家具房间','卫生间');
/*!40000 ALTER TABLE `category_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `comment_id` varchar(45) DEFAULT NULL,
  `commodity_id` varchar(45) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  `comment_date` varchar(45) DEFAULT NULL,
  `content` varchar(2048) DEFAULT NULL,
  `grade` varchar(45) DEFAULT NULL,
  `likeNum` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodities_img`
--

DROP TABLE IF EXISTS `commodities_img`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodities_img` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity_id` varchar(45) NOT NULL,
  `path` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=479 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodities_img`
--

LOCK TABLES `commodities_img` WRITE;
/*!40000 ALTER TABLE `commodities_img` DISABLE KEYS */;
INSERT INTO `commodities_img` VALUES (360,'book20210322184852963','images//commodity//phoneImg20210322184853217.jpg'),(361,'book20210322185126322','images//commodity//phoneImg20210322185126578.jpg'),(362,'book2021032218530258','images//commodity//phoneImg20210322185302300.jpg'),(363,'book20210322185452528','images//commodity//phoneImg20210322185452782.jpg'),(364,'book20210322185723401','images//commodity//phoneImg20210322185723641.jpg'),(365,'book20210322190208575','images//commodity//phoneImg20210322190208825.jpg'),(366,'book20210322190352106','images//commodity//phoneImg20210322190352347.jpg'),(367,'book20210322190702778','images//commodity//phoneImg2021032219070314.jpg'),(368,'book2021032219101388','images//commodity//phoneImg20210322191013330.jpg'),(369,'book20210322191453135','images//commodity//phoneImg20210322191453391.jpg'),(370,'book20210322191635763','images//commodity//phoneImg2021032219163648.jpg'),(371,'book20210322191808971','images//commodity//phoneImg20210322191809222.jpg'),(372,'book20210322192112226','images//commodity//phoneImg20210322192112463.jpg'),(373,'book20210322192301566','images//commodity//phoneImg20210322192301820.jpg'),(374,'book20210322192422164','images//commodity//phoneImg20210322192422416.jpg'),(378,'book20210322190838647','images//commodity//phoneImg20210324102006248.jpg'),(380,'book20210322190838647','images//commodity//phoneImg20210324102733940.jpg'),(381,'computer20210326155900381','images//commodity//img20210326155900647.jpg'),(382,'computer2021032616005839','images//commodity//img20210326160058264.webp'),(388,'computer2021032616005839','images//commodity//img20210326164813725.jpg'),(389,'computer2021032616005839','images//commodity//img2021032616481986.webp'),(390,'computer20210326171557730','images//commodity//img20210326171557980.webp'),(391,'book20210326195151882','images//commodity//img20210326195152207.jpg'),(392,'computer20210326195432398','images//commodity//img20210326195432632.jpg'),(393,'computer20210326200601647','images//commodity//img20210326200601875.webp'),(394,'computer20210326200936984','images//commodity//img20210326200937226.png'),(395,'computer20210326203943347','images//commodity//img20210326203943632.png'),(396,'computer20210326204037430','images//commodity//img20210326204037659.webp'),(397,'','images//commodity//img20210327075732551.jpg'),(398,'','images//commodity//img20210327080015919.jpg'),(399,'','images//commodity//img20210327080123711.jpg'),(400,'','images//commodity//img20210327080255313.jpg'),(401,'','images//commodity//img20210327080415769.jpg'),(402,'','images//commodity//img20210327080616705.jpg'),(403,'phone20210327080725562','images//commodity//img20210327080725800.jpg'),(404,'phone20210327080828833','images//commodity//img2021032708082976.jpg'),(405,'phone20210327081312829','images//commodity//img2021032708131359.jpg'),(406,'phone20210327131738557','images//commodity//img20210327131738825.jpg'),(407,'fur20210327140526538','images//commodity//img20210327140526819.png'),(408,'fur20210327152844926','images//commodity//img20210327152845196.jpg'),(409,'fur20210327165215929','images//commodity//img20210327165216243.jpg'),(410,'cloth20210327204837426','images//commodity//img20210327204837723.jpg'),(411,'cloth20210327214051395','images//commodity//img20210327214051694.jpg'),(412,'cloth2021032721512524','images//commodity//img20210327215125292.jpg'),(413,'food20210327221702942','images//commodity//img20210327221703212.webp'),(414,'food2021032723030850','images//commodity//img20210327230308310.jpg'),(415,'other20210328075023200','images//commodity//img20210328075023473.jpg'),(419,'food2021032808540053','images//commodity//img20210328085400291.jpg'),(421,'cloth20210328091744689','images//commodity//img20210328091744928.jpg'),(422,'fur20210328092610478','images//commodity//img20210328092610841.jpg'),(423,'food20210328093718782','images//commodity//img2021032809371948.jpg'),(426,'other20210328100408449','images//commodity//img20210328100408697.jpg'),(427,'other20210328100451269','images//commodity//img20210328100451522.jpg'),(430,'other20210328100747767','images//commodity//img2021032810074864.jpg'),(431,'food20210328100954159','images//commodity//img20210328100954401.jpg'),(432,'food20210328101229551','images//commodity//img20210328101229862.jpg'),(433,'food20210328101546823','images//commodity//img20210328101547103.jpg'),(434,'food20210328101800190','images//commodity//img20210328101800461.jpg'),(435,'fur20210328124710832','images//commodity//img20210328124711114.jpg'),(437,'phone20210327131738557','images//commodity//img2021032814335455.jpg'),(438,'food20210329191044396','images//commodity//img20210329191044632.jpg'),(439,'cloth20210405160426550','images//commodity//img20210405160426833.jpg'),(440,'computer20210405163553798','images//commodity//img2021040516355437.jpg'),(441,'computer20210405164652221','images//commodity//img20210405164652458.jpg'),(442,'food20210409093254316','images//commodity//img20210409093254714.jpg'),(443,'food20210409093718271','images//commodity//img20210409093718603.png'),(444,'book20210409093840415','images//commodity//img20210409093840801.jpg'),(445,'food20210409093934303','images//commodity//img20210409093934635.png'),(446,'food20210409094051489','images//commodity//img20210409094051840.png'),(447,'fur20210409095627723','images//commodity//img2021040909562877.png'),(448,'other20210414062600227','images//commodity//img20210414062600504.png'),(449,'food20210414063300577','images//commodity//img20210414063300827.jpg'),(450,'cloth20210414063612845','images//commodity//img2021041406361392.jpg'),(451,'fur20210414064721307','images//commodity//img20210414064721553.jpg'),(452,'cloth20210414065849176','images//commodity//img20210414065849405.jpg'),(453,'computer20210421210930275','images//commodity//img20210421210930569.jpg'),(455,'food20210611072032638','images//commodity//img20210611072032931.jpg'),(456,'food20210611072032638','images//commodity//img20210611072119730598.jpg'),(457,'food20210611072032638','images//commodity//img20210611072119738598.jpg'),(458,'food20210611080442934','images//commodity//img20210611080443177.jpg'),(459,'food20210611081508732','images//commodity//img20210611081508975.jpg'),(460,'food20210611082836680','images//commodity//img20210611082836927.jpg'),(461,'food20210611084555630','images//commodity//img20210611084555870.jpg'),(462,'food20210611084900949','images//commodity//img20210611084901193.jpg'),(463,'food20210611090423388','images//commodity//img20210611090423636.jpg'),(464,'food20210611091311284','images//commodity//img20210611091311529.jpg'),(465,'computer20210614203338401','images//commodity//img20210614203338642.jpg'),(466,'computer20210614203540797','images//commodity//img2021061420354142.jpg'),(467,'computer20210614203926502','images//commodity//img20210614203926749.jpg'),(468,'computer20210614204459215','images//commodity//img20210614204459453.jpg'),(469,'computer20210614204843121','images//commodity//img20210614204843364.jpg'),(470,'cloth20210615214956314','images//commodity//img20210615214956592.jpg'),(471,'cloth20210615215345324','images//commodity//img20210615215345562.jpg'),(472,'cloth20210615215631863','images//commodity//img20210615215632100.jpg'),(473,'cloth20210615220408941','images//commodity//img20210615220409188.jpg'),(474,'cloth20210615221608131','images//commodity//img20210615221608370.jpg'),(475,'fur20210615223438219','images//commodity//img20210615223438466.jpg'),(476,'fur20210615223636791','images//commodity//img2021061522363745.jpg'),(477,'fur20210615223959655','images//commodity//img20210615223959958.jpg'),(478,'book20210616085117599','images//commodity//img20210616085117993.jpg');
/*!40000 ALTER TABLE `commodities_img` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity`
--

DROP TABLE IF EXISTS `commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity_id` varchar(45) NOT NULL,
  `name` varchar(100) NOT NULL,
  `merchant_id` varchar(45) NOT NULL,
  `price` int NOT NULL,
  `introduce` varchar(6000) DEFAULT NULL,
  `category` varchar(45) NOT NULL,
  `main_img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=338 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity`
--

LOCK TABLES `commodity` WRITE;
/*!40000 ALTER TABLE `commodity` DISABLE KEYS */;
INSERT INTO `commodity` VALUES (228,'book20210322184852963','C++ Primer Plus 第6版 中文版--(异步图书出品)','mer20210322184201548',59,'C++是在 C 语言基础上开发的一种集面向对象编程、泛型编程和过程化编程于一体的编程语言，是C语言的超集。本书是根据2003年的ISO/ANSI C++标准编写的，通过大量短小精悍的程序详细而全面地阐述了 C++的基本概念和技术，并专辟一章介绍了C++11新增的功能。\n《C++ Primer Plus（第6版）中文版》分18章，分别介绍了C++程序的运行方式、基本数据类型、复合数据类型、循环和关系表达式、分支语句和逻辑运算符、函数重载和函数模板、内存模型和名称空间、类的设计和使用、多态、虚函数、动态内存分配、继承、代码重用、友元、异常处理技术、string类和标准模板库、输入/输出、C++11新增功能等内容。\n《C++ Primer Plus（第6版）中文版》针对C++初学者，从C语言基础知识开始介绍，然后在此基础上详细阐述C++新增的特性，因此不要求读者有C语言方面的背景知识。《C++ Primer Plus（第6版）中文版》可作为高等院校教授C++课程的教材，也可供初学者自学C++时使用。','图书','images//commodity//phoneImg20210322184853217.jpg'),(229,'book20210322185126322','Java编程思想（第4版） [thinking in java]','mer20210322184201548',72,'　《计算机科学丛书：Java编程思想（第4版）》赢得了全球程序员的广泛赞誉，即使是晦涩的概念，在BruceEckel的文字亲和力和小而直接的编程示例面前也会化解于无形。从Java的基础语法到高级特性（深入的面向对象概念、多线程、自动项目构建、单元测试和调试等），本书都能逐步指导你轻松掌握。\n　　从《计算机科学丛书：Java编程思想（第4版）》获得的各项大奖以及来自世界各地的读者评论中，不难看出这是一本经典之作。本书的作者拥有多年教学经验，对C、C++以及Java语言都有独到、深入的见解，以通俗易懂及小而直接的示例解释了一个个晦涩抽象的概念。本书共22章，包括操作符、控制执行流程、访问权限控制、复用类、多态、接口、通过异常处理错误、字符串、泛型、数组、容器深入研究、JavaI/O系统、枚举类型、并发以及图形化用户界面等内容。这些丰富的内容，包含了Java语言基础语法以及高级特性，适合各个层次的Java程序员阅读，同时也是高等院校讲授面向对象程序设计语言以及Java语言的好教材和参考书。\n　　《计算机科学丛书：Java编程思想（第4版）》特点：\n　　适合初学者与专业人员的经典的面向对象叙述方式，为更新的JavaSE5/6增加了新的示例和章节。\n　　测验框架显示程序输出。\n　　设计模式贯穿于众多示例中：适配器、桥接器、职责链、命令、装饰器、外观、工厂方法、享元、点名、数据传输对象、空对象、代理、单例、状态、策略、模板方法以及访问者。\n　　为数据传输引入了XML，为用户界面引入了SWT和Flash。\n　　重新撰写了有关并发的章节，有助于读者掌握线程的相关知识。\n　　专门为第4版以及JavaSE5/6重写了700多个编译文件中的500多个程序。\n　　支持网站包含了所有源代码、带注解的解决方案指南、网络日志以及多媒体学习资料。\n　　覆盖了所有基础知识，同时论述了高级特性。\n　　详细地阐述了面向对象原理。\n　　在线可获得Java讲座CD，其中包含BruceEckel的全部多媒体讲座。\n　　在网站上可以观看现场讲座、咨询和评论。\n　　专门为第4版以及JavaSE5/6重写了700多个编译文件中的500多个程序。\n　　支持网站包含了所有源代码、带注解的解决方案指南、网络日志以及多媒体学习资料。\n　　覆盖了所有基础知识，同时论述了高级特性。\n　　详细地阐述了面向对象原理。','图书','images//commodity//phoneImg20210322185126578.jpg'),(230,'book2021032218530258','Python编程 从入门到实践 第2版(图灵出品)','mer20210322184201548',61,'本书是针对所有层次Python读者而作的Python入门书。全书分两部分：第一部分介绍用Python编程所必须了解的基本概念，包括强大的Python库和工具，以及列表、字典、if语句、类、文件与异常、代码测试等内容；第二部分将理论付诸实践，讲解如何开发三个项目，包括简单的2D游戏、利用数据生成交互式的信息图以及创建和定制简单的Web应用，并帮助读者解决常见编程问题和困惑。第2版进行了全面修订，简化了Python安装流程，新增了f字符串、get()方法等内容，并且在项目中使用了Plotly库以及新版本的Django和Bootstrap，等等。','图书','images//commodity//phoneImg20210322185302300.jpg'),(231,'book20210322185452528','从Docker源码学习Go语言套装（京东套装共2册）','mer20210322184201548',110,'　　本书由《C程序设计语言》的作者Kernighan和谷歌公司Go团队主管AlanDonovan联袂撰写，是学习Go语言程序设计指南。本书共13章，主要内容包括：Go的基础知识、基本结构、基本数据类型、复合数据类型、函数、方法、接口、goroutine、通道、共享变量的并发性、包、go工具、测试、反射等。本书适合作为计算机相关专业的教材，也可供Go语言爱好者阅读。\n本书从Docker基本原理开始，深入浅出地讲解Docker的构建与操作，内容系统全面，可帮助开发人员、运维人员快速部署Docker应用。本书分为四大部分：基础入门、实战案例、进阶技能、开源项目，第一部分（第1～8章）介绍Docker与虚拟化技术的基本概念，包括安装、镜像、容器、仓库、数据卷，端口映射等；第二部分（第9～16章）通过案例介绍Docker的应用方法，包括与各种操作系统平台、SSH服务的镜像、Web服务器与应用、数据库的应用、各类编程语言的接口、容器云等，还介绍了作者在容器实战中的思考与经验总结；第三部分（第17～21章）是一些进阶技能，如Docker核心技术实现原理、安全、高级网络配置、libernetwork插件化网络功能等；第四部分（第22～28章）介绍与容器开发相关的开源项目，包括Etcd、Docker Machine、Docker Compose、Docker Swarm、Mesos、Kubernetes等。\n\n第2版参照Docker技术的*新进展对全书内容进行了修订，并增加了第四部分专门介绍与容器相关的知名开源项目，利用好这些优秀的开源平台，可以更好地在生产实践中受益。','图书','images//commodity//phoneImg20210322185452782.jpg'),(232,'book20210322185723401','算法导论（原书第3版）/计算机科学丛书 [Introduction to Algorithms, third edition]','mer20210322184201548',85,'　　在有关算法的书中，有一些叙述非常严谨，但不够全面；另一些涉及了大量的题材，但又缺乏严谨性。《算法导论（原书第3版）/计算机科学丛书》将严谨性和全面性融为一体，深入讨论各类算法，并着力使这些算法的设计和分析能为各个层次的读者接受。全书各章自成体系，可以作为独立的学习单元；算法以英语和伪代码的形式描述，具备初步程序设计经验的人就能看懂；说明和解释力求浅显易懂，不失深度和数学严谨性。\n　　《算法导论（原书第3版）/计算机科学丛书》全书选材经典、内容丰富、结构合理、逻辑清晰，对本科生的数据结构课程和研究生的算法课程都是非常实用的教材，在IT专业人员的职业生涯中，《算法导论（原书第3版）/计算机科学丛书》也是一本案头必备的参考书或工程实践手册。\n　　第3版的主要变化：\n　　·新增了van Emde Boas树和多线程算法，并且将矩阵基础移至附录。\n　　·修订了递归式（现在称为“分治策略”）那一章的内容，更广泛地覆盖分治法。\n　　·移除两章很少讲授的内容：二项堆和排序网络。\n　　·修订了动态规划和贪心算法相关内容。\n　　·流网络相关材料现在基于边上的全部流。\n　　·由于关于矩阵基础和Strassen算法的材料移到了其他章，矩阵运算这一章的内容所占篇幅更小。\n　　·修改了对Knuth-Morris-Pratt字符串匹配算法的讨论。\n　　·新增100道练习和28道思考题，还更新并补充了参考文献。','图书','images//commodity//phoneImg20210322185723641.jpg'),(233,'book20210322190208575','心 （“国民大作家” 夏目漱石剖心之作）','mer20210322184248180',16,'先生自杀了。他留下一封长长的遗书，里面细细描述了那片一直盘旋在他内心深处的阴影：那是一场爱情与友情的冲突，一次利己之心与道义之心的交锋……\n\n小说《心》是日本“国民级作家”夏目漱石的代表作之一。故事由“先生与我”“父母与我”“先生与遗书”三个部分组成。夏目漱石借“先生”这一角色，以及发生在他与友人“K”之间的故事，呈现了弥漫于近代日本社会中的怅惘与无助情绪。夏目漱石在作品中对人心复杂所做的细腻刻画，也使它成为经典的剖析人类心灵之作。','图书','images//commodity//phoneImg20210322190208825.jpg'),(234,'book20210322190352106','我是猫','mer20210322184248180',20,'　《我是猫》是日本“国民大师”夏目漱石的代表成名作，对日本文学有着极深远的影响。\n　　《我是猫》的写作角度很新颖，从一只猫的视角来观察身边的人和事。这只猫生活在一个教师家中，见识了形形色色各种文人：没心没肺无厘头，唯恐天下不乱的迷亭；古板又一丝不苟，有点不知变通的寒月；理想主义，空有理论不实践的独仙……当然还有猫咪的主人，迂腐没耐心，做事三分钟热度，自命清高的苦沙弥。在猫的眼里，这些人聚在一起成天讨论些没意义的事情，不满现实，也就只会抱怨，像苦沙弥，被私塾的学生恶作剧整得苦不堪言，被邻居嘲笑，却都无可奈何。同时，猫咪也见识到了与苦沙弥不同阶级的另外一些人：一心想把女儿嫁出去，势利眼的“大鼻子”，资本家金田的老婆；跟老婆一个鼻孔出气，知道苦沙弥挖苦阻挠女儿的婚事后还派人陷害的资本家金田；还有一群穷苦出生，为金钱所动，帮助金田家嘲笑陷害苦沙弥的邻居……这些人在猫咪看来也是丑恶不堪的。\n　　整部小说可以总结为五个字“猫眼看世界”，小说中大大小小十几号人物在夏目漱石笔下都是性格鲜明，小说构思奇巧，描写夸张，结构灵活，具有鲜明的艺术特色。','图书','images//commodity//phoneImg20210322190352347.jpg'),(235,'book20210322190702778','且听风吟 1','mer20210322184248180',23,'《且听风吟》是村上春树小说的语言风格、写作技巧和后现代主义艺术氛围的源头与雏形，是作家从摆脱日文小说文本平庸拖沓的理念出发，借鉴美国现代小说简洁明快的文风，所完成的小说文本的革命性变革，是当代日本小说精神和文学价值的重要体现','图书','images//commodity//phoneImg2021032219070314.jpg'),(236,'book20210322190838647','村上春树：挪威的森林（精装） [ノルウエイ]','mer20210322184248180',24,'《挪威的森林》是日本小说家村上春树的长篇小说，描写一个背井离乡的大学生，爱上了一个忧郁深情的少女，同时也被一个热情奔放的少女所吸引，在两个少女之间徘徊，表现了初涉人世的年轻人的独特爱情观，是一部非常规的青春恋爱小说，也是作者的名作。本书2001年我社出版平装本 ，2007年出版精装本，此次是第二个的精装本，译者林少华教授对译文作了大量的修订，并新写了译序。修订的重头是当代西方文化、生活的名词，比如电影名、歌曲名、品牌服装的名称，因为初版译本出版时，这些电影、歌曲、品牌等尚未在我国流传，国内也没有固定的译名，林教授只能按日语原文直译，这次均按通行译法作了修正。除此以外，修订中也纠正了少量误译、漏译。','图书','images//commodity//phoneImg20210324102733940.jpg'),(237,'book2021032219101388','言叶之庭---','mer20210322184248180',28,'以成为制鞋师为职业目标的高中生孝雄在下雨天的公园里遇到了年长的神秘女子——雪野。在梅雨季里，两人总是不约而同地在这里碰面。几次相谈之下，两颗年轻的心也渐渐靠近。背负着压力的雪野受挫后感到迷茫，甚至不知道之后的人生该如何走下去。年轻的孝雄不愿看到雪野继续低迷，表明了自己的心意，并完成了为她量身定做的一双女鞋……','图书','images//commodity//phoneImg20210322191013330.jpg'),(238,'book20210322191453135','新东方 托福考试官方指南：第5版 托福官指 ETS','mer20210322184325796',141,'《托福考试官方指南：第5版》首先概述托福考试信息，包括考试内容、考试流程、考试策略以及评分标准等。然后，分四大部分讲解阅读、听力、口语和写作。每部分都分类介绍考试题型，结合典型例题剖析题目特点并给出解题策略。此外，阅读和听力部分还分别给出6套和5套针对性练习；口语和写作部分分别给出评分细则、回答范例和考官评分意见。最后，提供4套全真模拟题，以两种形式给出——纸版和DVD光盘模考软件，供考生自测并熟悉托福实考环境。','图书','images//commodity//phoneImg20210322191453391.jpg'),(239,'book20210322191635763','【新东方旗舰】托业听力全真模拟1000题+阅读全真模拟1000题(共2本)','mer20210322184325796',69,'\n托业制胜利器，依据题型改革要求全新改版，助考生充分备战，轻松搞定托业考试！\n\n本书引进自韩国多乐园出版社。该社成立于1977年，在韩国英语教育出版领域有较好的口碑。本书是韩国畅销的托业书之一，是韩国众多学校和培训机构的指定教材，在托业考生中享有很高的声誉。\n\n《托业听力全真模拟1000题》是针对新托业考试听力部分编写的高仿真模拟试题集，共包含10套完整的听力试卷，共计1000道题目。这些题目的编写严格遵循了新托业听力各题型的命题特点和考查思路，涵盖了在真实考试中*常出现的各种语言要点，仿真度高，针对性强。可以帮助不同语言基础的考生在短期内迅速熟悉考试中经常出现的场景、话题和语言素材，掌握正确答案的特征并规避错项陷阱，提升听力理解能力，冲刺托业听力高分！\n\n随着时代的发展，英语的应用场合越来越多元化，对英语能力的需求也在随之变化。为了适应这一潮流，ETS为TOEIC考试研发了新的题型。为了帮助广大考生更好地了解新托业考试的要求和特点，新东方引进了一系列与托业考试相关的辅导用书。\n\n   《托业听力全真模拟1000题》是该丛书之一，包含10套高度仿真的模拟试卷，共计1000道听力模拟试题。解析部分不仅附有听力原文及选项的全文翻译，而且还针对其中出现的重点词汇、短语和句型进行了系统归纳和扩展，以帮助考生达到举一反三的学习效果。本书所有题目均严格遵循新托业听力考试的要求，涵盖考试中可能出现的各种场景和话题。\n\n本书提供免费配套的MP3音频。听力材料由英、美、澳、加等多国人士朗读，囊括新托业听力考试中可能出现的所有口音。考生可登录封面上提供的网络地址免费下载音频资料，还可扫描封底二维码在线收听。\n\n另外，为了更方便考生进行实战练习，本书*后附赠托业考试听力部分（Part 1~4）的实考答题卡10份，考生可以自行剪下使用。希望本书能帮助广大考生取得托业听力高分！\n\n·专业录音：听力材料由英、美、澳、加等多国人士朗读，囊括新托业听力考试中可能出现的所有口音。\n\n·全文翻译：所有问题、选项和听力原文均配有全文翻译，帮助考生彻底扫除听力理解障碍。\n\n·高频表达：根据不同题型的特点提供相应的扩展表达，帮助考生扩充语言知识储备。\n\n《托业阅读全真模拟1000题》是针对新托业考试阅读部分编写的高仿真模拟试题集，共包含10套完整的阅读试卷，共计1000道题目。这些题目的编写严格遵循了新托业阅读各题型的命题特点和考查思路，涵盖了在真实考试中经常出现的各种语言要点，仿真度高，针对性强。可以帮助不同语言基础的考生在短期内迅速熟悉考试中经常出现的场景、话题和语言素材，掌握正确答案的特征并规避错项陷阱，提升阅读理解能力，冲刺托业阅读高分！\n\n随着时代的发展，英语的应用场合越来越多元化，对英语能力的需求也在随之变化。为了适应这一潮流，ETS为TOEIC考试研发了新的题型。为了帮助广大考生更好地了解新托业考试的要求和特点，新东方引进了一系列与托业考试相关的辅导用书。\n\n《托业阅读全真模拟1000题》是该丛书之一，包含10套高度仿真的模拟试卷，共计1000道阅读模拟试题，能够满足考生在基础复习和考前冲刺阶段的练习需要。本书所有题目均严格遵循新托业阅读考试的题型改革要求编写，涵盖考试中经常出现的各种语言要点。汇总新托业阅读考试中经常出现的词汇和短语，帮助考生扩充语言知识储备。书中所有问题、选项和阅读原文均配有全文翻译，帮助考生彻底扫除阅读理解障碍。\n\n另外，为了更方便考生进行实战练习，本书*后附赠托业考试阅读部分（Part 5~7）的实考答题卡10份，考生可以自行剪下使用。希望本书能帮助广大考生取得托业阅读高分！\n\n·题型介绍：介绍新托业阅读各题型的考试形式、题目类型和考查重点，帮助考生做好复习准备。\n\n·仿真练习：所有题目均严格遵循新托业阅读考试的要求，涵盖考试中可能会出现的各种考点。\n\n·高频表达：汇总阅读中经常出现的词汇和短语，帮助考生扩充语言知识储备。\n\n·题目解析：分析得出正确答案的基本思路，帮助考生在实战中提高答题速度。\n\n·全文翻译：所有文章和题目均配有全文翻译，帮助考生彻底扫除阅读理解障碍。','图书','images//commodity//phoneImg2021032219163648.jpg'),(240,'book20210322191808971','红宝书蓝宝书新日本语能力考试N2套装：文法+文字词汇(详解+练习)（套装共2册）','mer20210322184325796',59,'　《新日本语能力考试文法（详解+练习）》特点：\n　　180句型+900练习+敬语点睛，名师精讲、逼真实战！\n　　新增新真题例解，还原把握命题思路！\n　　全面梳理，逼真演练，深度分析，直击考点！\n　　接续+说明+真题例文+用法注意，超强阵容 透彻掌握！\n　　相似辨析+分类总结，精炼点拨 化解疑难！\n　　核心提炼句型，重点精确定位，全境模拟练习，语法掌握不留死角！\n　　\n　　《新日本语能力考试文字词汇（详解+练习）》特点：\n　　增设特别单元，汇总新真题重要词汇!\n　　4400词条+2000练习 突显重点 凝炼细节\n　　汉字+声调+假名+释义+例句 超强阵容、背练强化！\n　　近义词+反义词+关联词+同音词+惯用法 串联记忆、透彻掌握！','图书','images//commodity//phoneImg20210322191809222.jpg'),(241,'book20210322192112226','东野圭吾：白夜行（2017版）','mer202103221843584',30,'《白夜行》被普遍视为日本作家东野圭吾作品的无冕之·王，一经推出即成为东野圭吾的长篇小说代表作，中文版发行量超600万册，与《嫌疑人X的献身》《恶意》《解忧杂货店》并称为东野圭吾四大杰作。\n\n《白夜行》是东野圭吾当之无愧的鸿篇巨制，全书故事跨越19年时间，登场人物超过50个，草蛇灰线伏脉千里，情节线索纵横交错又丝丝入扣，用一桩离奇命案牵出案件相关人跨越19年惊心动魄的故事、悲凉的爱情、吊诡的命运、令人发指的犯罪、白描又生动的社会图景、复杂人性的对决与救赎，读来令人叹为观止。\n\n1973年，大阪一栋废弃建筑中发现一名遭利器刺死的男子。警方怀疑一个叫西本文代的女人，但缺少证据。不久西本被判定因意外事故死亡，从此案件成谜。此后19年，众多案件相关者的命运出现了离奇的转折，有人走向上流社会，有人在暗夜中游走挣扎。只有一个老警察追查不休，渐渐拼出了惊人的真相。','图书','images//commodity//phoneImg20210322192112463.jpg'),(242,'book20210322192301566','东野圭吾:时生（2015版） [時生]','mer202103221843584',18,'《时生》内容简介：日本推理小说天王东野圭吾长篇小说，带给现代人久违触动的暖心力作。23岁的拓实一事无成。他从小被人收养，一直以为自己被抛弃了，于是自暴自弃。一天，他在东京的花屋敷游乐园遇到了一个年轻人。年轻人对他说：“再过几年，你会结婚生子，你将给你的儿子取名为时生，时间的时，生命的生。那孩子长到17岁时，因某种缘故而回到过去，那就是我。”\n\n作者简介','图书','images//commodity//phoneImg20210322192301820.jpg'),(243,'book20210322192422164','东野圭吾：解忧杂货店','mer202103221843584',30,'《解忧杂货店》是东野圭吾的奇迹之作，运用巧妙的构思和奇幻的设定，让温情、惊喜与感动悄然渗入读者心中，回味无穷。《解忧杂货店》的销量已突破1000万册，为此，东野圭吾特别寄语中国读者：“《解忧杂货店》能在中国拥有这么多读者，对我而言既是荣幸也是鼓励。我想在这本书中写的，是无论身处哪个国家、哪个时代的人都一定会抱有的‘梦想’与‘烦恼’。人之所以为人，正是因为这无尽的梦想与烦恼吧。”\n\n内容简介：\n\n僻静的街道上有一家杂货店，只要写下烦恼投进卷帘门的投信口，第二天就会在店后的牛奶箱里得到回答。\n\n因男友身患绝症，在爱情与梦想间徘徊；为了音乐梦想离家漂泊，却在现实中寸步难行；面临家庭巨变，挣扎在亲情与未来的迷茫中……\n\n他们将困惑写成信投进杂货店，随即奇妙的事情竟不断发生。','图书','images//commodity//phoneImg20210322192422416.jpg'),(267,'computer20210326204037430','surface pro 6','mer20210322184201548',9888,'zzz','电脑','images//commodity//img20210326204037659.webp'),(277,'phone20210327081312829','华为 HUAWEI Mate 40 Pro','mer20210322184201548',6900,'我就用华为','手机','images//commodity//img2021032708131359.jpg'),(278,'phone20210327131738557','Redmi-9A','mer20210322184201548',19000,'自发热充电宝','手机','images//commodity//img2021032814335455.jpg'),(302,'computer20210405163553798','华为笔记本电脑MateBook X','mer20210322184201548',9988,'华为笔记本电脑MateBook X 2020款 13英寸 时尚轻薄本 (英特尔十代酷睿i7 16GB 512GB) 3K触控全面屏 青山黛','电脑','images//commodity//img2021040516355437.jpg'),(303,'computer20210405164652221',' MacBook Pro 13.3','mer20210322184201548',13339,'Apple 2020款 MacBook Pro 13.3【带触控栏】十代i5 16G 512G 2.0GHz 深空灰 笔记本电脑 轻薄本 MWP42CH/A','电脑','images//commodity//img20210405164652458.jpg'),(309,'fur20210409095627723','沙发','mer20210322184201548',198000,'沙发','家具','images//commodity//img2021040909562877.png'),(310,'other20210414062600227','尼康（Nikon） AF-S 50mm f/1.8G 镜头','mer20210322184201548',1580,'镜头很好','其他','images//commodity//img20210414062600504.png'),(311,'food20210414063300577','奥利奥（Oreo）原味夹心饼干','mer20210322184201548',20,' 奥利奥（Oreo）原味夹心饼干 办公室下午茶休闲零食家庭装349g独立小包分享装 囤货必备（新老包装随机发货）','食品','images//commodity//img20210414063300827.jpg'),(312,'cloth20210414063612845','Jack Wolfskin 狼爪运动短袖T恤','mer20210322184201548',99,'Jack Wolfskin 狼爪运动短袖T恤5010811/5010801/5010812 男款铁灰色6116 男装S码170/92A','服装','images//commodity//img2021041406361392.jpg'),(313,'fur20210414064721307','钢化玻璃电视柜茶几组合','mer20210322184201548',318,'众创造新 钢化玻璃电视柜茶几组合客厅烤漆伸缩电视机柜现代简约小户型地柜 黑【白门太阳花1.6-2.2】新','家具','images//commodity//img20210414064721553.jpg'),(314,'cloth20210414065849176','李宁（LI-NING)卫衣','mer20210322184201548',99,'李宁（LI-NING)卫衣男套春季宽松头衫圆领上衣男士长袖运动服支持新疆棉','服装','images//commodity//img20210414065849405.jpg'),(317,'food20210611080442934','螺霸王 螺蛳粉330g*6 广西柳州特产 ','mer2021061108001438',77,'低温油炸，香甜脆口；泡进汤汁好吃到不行','食品','images//commodity//img20210611080443177.jpg'),(318,'food20210611081508732','康师傅方便面红烧牛肉袋面泡面五连包休闲零食 ','mer2021061108001438',13,'红烧牛肉面','食品','images//commodity//img20210611081508975.jpg'),(319,'food20210611082836680','蒙牛 特仑苏 纯牛奶 ','mer2021061108001438',87,'限定场地，精选牧场','食品','images//commodity//img20210611082836927.jpg'),(320,'food20210611084555630','福临门 本来长粒香米','mer2021061108001438',40,'精选大米','食品','images//commodity//img20210611084555870.jpg'),(321,'food20210611084900949',' 西王玉米胚芽油6.18L','mer2021061108001438',125,'好油','食品','images//commodity//img20210611084901193.jpg'),(322,'food20210611090423388',' 爱普诗（Alpes d\'Or）','mer2021061108001438',109,'巧克力非常好吃非常好吃非常好吃','食品','images//commodity//img20210611090423636.jpg'),(323,'food20210611091311284','卫龙大面筋 ','mer2021061108001438',3,'辣条','食品','images//commodity//img20210611091311529.jpg'),(324,'computer20210614203338401','联想笔记本电脑 ThinkBook 14 ','mer20210614202835273',4299,'联想电脑，真的很好','电脑','images//commodity//img20210614203338642.jpg'),(325,'computer20210614203540797','RedmiBook Pro 15 轻薄本','mer20210614202835273',4699,'RedmiBook Pro 15 轻薄本(11代酷睿i5-11300H 16G 512G PCIE 锐炬显卡 3.2K 90Hz全面屏) 红米小米笔记本电脑','电脑','images//commodity//img2021061420354142.jpg'),(326,'computer20210614203926502','惠普（HP）战66 四代','mer20210614202835273',5799,'惠普（HP）战66 四代 14英寸轻薄笔记本电脑（英特尔酷睿11代i5 16G 512G MX450 高色域 一年上门+意外）','电脑','images//commodity//img20210614203926749.jpg'),(327,'computer20210614204459215','华硕无畏Pro14','mer20210614202835273',4999,'华硕无畏Pro14 标压锐龙版 2.8K OLED屏轻薄笔记本电脑(R7-5800H 16G 512G 133%sRGB高色域 600尼特 90Hz)银','电脑','images//commodity//img20210614204459453.jpg'),(328,'computer20210614204843121','VAIO FH14 侍14Pro','mer20210614202835273',7999,'VAIO FH14 侍14Pro 11代标压14英寸1.4Kg高性能轻薄笔记本电脑(i7-11370H-16G-512G GTX1650Ti 高色域)斑斓黑','电脑','images//commodity//img20210614204843364.jpg'),(329,'cloth20210615214956314','雅戈尔 衬衫男 春季推荐衬衫','mer20210421211319186',469,'雅戈尔 衬衫男 春季推荐衬衫 长袖衬衫 衬衫男修身 牛津纺衬衫 商务休闲 浅蓝GLXX100224IKY 41','服装','images//commodity//img20210615214956592.jpg'),(330,'cloth20210615215345324','比音勒芬 修身衬衫男长袖衬衫','mer20210421211319186',1080,'【商场同款】比音勒芬2021春夏新品男士纯色高级感商务上班修身衬衫男长袖衬衫男亲肤舒适透气弹力 35深蓝色 100/M','服装','images//commodity//img20210615215345562.jpg'),(331,'cloth20210615215631863','衬衫男韩版潮流格纹长袖衬衫','mer20210421211319186',238,'Lilbetter衬衫男韩版潮流格纹长袖衬衫春季薄款格子外套男士衬衣 花色 L','服装','images//commodity//img20210615215632100.jpg'),(332,'cloth20210615220408941','鳄鱼恤 ','mer20210421211319186',158,'鳄鱼恤 CROCODILE 夹克男春季潮流男士外套韩版休闲连帽风衣男上衣男百搭男装 GLY 3126 深灰 XL','服装','images//commodity//img20210615220409188.jpg'),(333,'cloth20210615221608131','言衡风衣男士中长款','mer20210421211319186',198,'言衡风衣男士中长款新款春季休闲男士外套男装潮流宽松连帽工装大衣大码青年学生上衣服服装 米色B230 172-180/XL（130-155斤）','服装','images//commodity//img20210615221608370.jpg'),(334,'fur20210615223438219','多用途脏衣篮','mer20210322184325796',97,'利快 多用途脏衣篮日本进口like-it洗衣篮杂物卫浴收纳篮整理筐 白色单个 大号27.7x45.5x39cm','家具','images//commodity//img20210615223438466.jpg'),(335,'fur20210615223636791','爱丽思（IRIS）','mer20210322184325796',598,'爱丽思IRIS 收纳柜儿童衣柜收纳箱抽屉式储物柜五斗柜床头柜 爱丽丝日韩简约玩具整理柜环保材质 白/梨色五层','家具','images//commodity//img2021061522363745.jpg'),(336,'fur20210615223959655','意式极简科技布艺沙发','mer20210322184325796',1980,'上林春天 意式极简科技布艺沙发现代简约中小户型直排三人位组合沙发客厅家具 深灰+米白 2.1米【三人位+脚踏】','家具','images//commodity//img20210615223959958.jpg');
/*!40000 ALTER TABLE `commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_categories`
--

DROP TABLE IF EXISTS `commodity_categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity_categories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_categories`
--

LOCK TABLES `commodity_categories` WRITE;
/*!40000 ALTER TABLE `commodity_categories` DISABLE KEYS */;
/*!40000 ALTER TABLE `commodity_categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_categories_books`
--

DROP TABLE IF EXISTS `commodity_categories_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity_categories_books` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity_id` varchar(45) NOT NULL,
  `book_name` varchar(100) NOT NULL,
  `publishing` varchar(45) NOT NULL,
  `book_type` varchar(45) DEFAULT NULL,
  `book_isbn` varchar(45) NOT NULL,
  `publishing_date` varchar(45) NOT NULL,
  `book_brand` varchar(45) NOT NULL,
  `number_of_pages` int NOT NULL,
  `book_price` int NOT NULL,
  `author` varchar(256) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=146 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_categories_books`
--

LOCK TABLES `commodity_categories_books` WRITE;
/*!40000 ALTER TABLE `commodity_categories_books` DISABLE KEYS */;
INSERT INTO `commodity_categories_books` VALUES (127,'book20210322184852963','C++ Primer Plus 第6版 中文版--(异步图书出品)','人民邮电出版社','','9787115521644','2020-06-30T16:00:00.000Z','异步图书',678,59,'[美] 史蒂芬·普拉达（Stephen Prata）'),(128,'book20210322185126322','Java编程思想（第4版） [thinking in java]','机械工业出版社','','9787111213826','2021-03-06T16:00:00.000Z','机械工业',880,72,'[美] Bruce Eckel'),(129,'book2021032218530258','Python编程 从入门到实践 第2版(图灵出品)','人民邮电出版社','','9787115546081','2021-03-28T16:00:00.000Z','iTuring',445,61,'[美] 埃里克·马瑟斯（Eric Matthes）'),(130,'book20210322185452528','从Docker源码学习Go语言套装（京东套装共2册）','机械工业出版社','','12214561','2021-02-28T16:00:00.000Z','机械工业出版社',901,110,'艾伦A. A. 多诺万'),(131,'book20210322185723401','算法导论（原书第3版）/计算机科学丛书 [Introduction to Algorithms, third edition]','机械工业出版社','','9787111407010','2021-03-07T16:00:00.000Z','机工出版',796,85,'Thomas H.Cormen，[美] Charles E.Leiserson，[美] Ronald L.Rivest，[美] Clifford Stein'),(132,'book20210322190208575','心 （“国民大作家” 夏目漱石剖心之作）','河北教育出版社','','9787554557044','2021-03-01T16:00:00.000Z','有容书邦',490,16,'夏目漱石'),(133,'book20210322190352106','我是猫','浙江文艺出版社','','9787533942236','2021-03-28T16:00:00.000Z','果麦',512,20,'夏目漱石'),(134,'book20210322190702778','且听风吟 1','上海译文出版社','','9787532742936','2021-03-21T16:00:00.000Z','上海译文出版社',349,23,'春上村树'),(135,'book20210322190838647','村上春树：挪威的森林（精装） [ノルウエイ]','上海译文出版社','','9787532765546','2021-03-01T16:00:00.000Z','上海译文出版社',398,24,'村上春树'),(136,'book2021032219101388','言叶之庭---','百花洲文艺出版社','','9787550031371','2021-03-22T16:00:00.000Z','天闻角川',192,28,'新海诚'),(137,'book20210322191453135','新东方 托福考试官方指南：第5版 托福官指 ETS','群言出版社','','9787519303365','2021-03-29T16:00:00.000Z','新东方',756,141,'ETS（美国教育考试服务中心）'),(138,'book20210322191635763','【新东方旗舰】托业听力全真模拟1000题+阅读全真模拟1000题(共2本)','群言出版社','','9787802560987tz2','2021-02-28T16:00:00.000Z','新东方',464,69,'[韩] Jim Lee '),(139,'book20210322191808971','红宝书蓝宝书新日本语能力考试N2套装：文法+文字词汇(详解+练习)（套装共2册）','华东理工大学出版社','','11751443','2021-03-29T16:00:00.000Z','华东理工大学出版社',567,59,'许小明'),(140,'book20210322192112226','东野圭吾：白夜行（2017版）','南海出版公司','','9787544291163','2021-03-22T16:00:00.000Z','新经典',608,30,'东野圭吾'),(141,'book20210322192301566','东野圭吾:时生（2015版） [時生]','南海出版公司','','9787544277723','2021-03-30T16:00:00.000Z','新经典',312,18,'东野圭吾'),(142,'book20210322192422164','东野圭吾：解忧杂货店','南海出版公司','','9787544298995','2021-03-28T16:00:00.000Z','新经典',320,30,'东野圭吾');
/*!40000 ALTER TABLE `commodity_categories_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_categories_computer`
--

DROP TABLE IF EXISTS `commodity_categories_computer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity_categories_computer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity_id` varchar(45) NOT NULL,
  `computer_name` varchar(45) NOT NULL,
  `computer_type` varchar(45) NOT NULL,
  `price` varchar(45) NOT NULL,
  `computer_cpu` varchar(45) NOT NULL,
  `computer_memory` varchar(45) NOT NULL,
  `computer_disk` varchar(45) NOT NULL,
  `computer_system` varchar(45) NOT NULL,
  `computer_resolution` varchar(45) NOT NULL,
  `computer_brand` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_categories_computer`
--

LOCK TABLES `commodity_categories_computer` WRITE;
/*!40000 ALTER TABLE `commodity_categories_computer` DISABLE KEYS */;
INSERT INTO `commodity_categories_computer` VALUES (30,'computer20210326204037430','surface pro 6','笔记本','9888.00','i7','16GB','1T','Windows 10','198081080','微软'),(31,'computer20210405163553798','华为笔记本电脑MateBook X','笔记本','9988.00','Intel i7','16G','512G','Windows 10','超高清屏（2K/2.5K/3K/4K）','华为'),(32,'computer20210405164652221',' MacBook Pro 13.3','笔记本','13339.00','Intel i5','16G','512G','Mac','超高清屏（2K/2.5K/3K/4K）','苹果'),(34,'computer20210614203338401','联想笔记本电脑 ThinkBook 14 ','笔记本','4299.00 ','AMD R5','16GB','512GB','Windows 10','1920×1080','联想'),(35,'computer20210614203540797','RedmiBook Pro 15 轻薄本','笔记本','4699.00 ','Intel i5','16GB','512GB','Windows 10','超高清屏（2K/2.5K/3K/4K）','小米'),(36,'computer20210614203926502','惠普（HP）战66 四代','笔记本',' 5799.00 ','Intel i7 ','16GB','512GB','Windows 10','全高清屏（1920×1080）','惠普'),(37,'computer20210614204459215','华硕无畏Pro14','笔记本','4999.00','AMD 锐龙 7','16GB','512GB','Windows 10','超高清屏（2K/2.5K/3K/4K）','华硕'),(38,'computer20210614204843121','VAIO FH14 侍14Pro','笔记本','7999.00','Intel i7','16GB','512GB','Windows 10','全高清屏（1920×1080）','VIVO');
/*!40000 ALTER TABLE `commodity_categories_computer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_categories_phone`
--

DROP TABLE IF EXISTS `commodity_categories_phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity_categories_phone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `phone_name` varchar(45) NOT NULL,
  `commodity_id` varchar(45) NOT NULL,
  `phone_cpu` varchar(45) NOT NULL,
  `phone_price` varchar(45) NOT NULL,
  `phone_memory` varchar(45) NOT NULL,
  `phone_system` varchar(45) NOT NULL,
  `phone_storage` varchar(45) NOT NULL,
  `phone_brand` varchar(45) NOT NULL,
  `phone_length` varchar(45) NOT NULL,
  `phone_weight` varchar(45) NOT NULL,
  `main_pixel` varchar(45) NOT NULL,
  `phone_resolution` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_categories_phone`
--

LOCK TABLES `commodity_categories_phone` WRITE;
/*!40000 ALTER TABLE `commodity_categories_phone` DISABLE KEYS */;
/*!40000 ALTER TABLE `commodity_categories_phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_clothing`
--

DROP TABLE IF EXISTS `commodity_clothing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity_clothing` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity_id` varchar(45) DEFAULT NULL,
  `commodity_name` varchar(45) DEFAULT NULL,
  `market_time` varchar(45) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `cloth_type` varchar(45) DEFAULT NULL,
  `apply_to_session` varchar(45) DEFAULT NULL,
  `commodity_weight` varchar(45) DEFAULT NULL,
  `suitable` varchar(45) DEFAULT NULL,
  `clothing_style` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_clothing`
--

LOCK TABLES `commodity_clothing` WRITE;
/*!40000 ALTER TABLE `commodity_clothing` DISABLE KEYS */;
INSERT INTO `commodity_clothing` VALUES (13,'cloth20210414063612845','Jack Wolfskin 狼爪运动短袖T恤','20200101','Jack Wolfskin ',99,'衬衫','春季','300.00g','青少年','中式'),(14,'cloth20210414065849176','李宁（LI-NING)卫衣','20200102','李宁',99,'休闲装','春季','500.00g','青少年','中式'),(15,'cloth20210615214956314','雅戈尔 衬衫男 春季推荐衬衫','2020年秋季','雅戈尔',469,'衬衫','春季','1.0kg','青少年','英伦'),(16,'cloth20210615215345324','比音勒芬 修身衬衫男长袖衬衫','2021年春季','比音勒芬',1080,'衬衫','春季','1.0kg','青少年','中式'),(17,'cloth20210615215631863','衬衫男韩版潮流格纹长袖衬衫','2021年春季','Lilbetter',238,'衬衫','春季','1.0kg','青少年','英伦'),(18,'cloth20210615220408941','鳄鱼恤 ','2020年秋季','夹克男春季潮流男士外套',158,'户外装','春季','450.00g','青少年','中式'),(19,'cloth20210615221608131','言衡风衣男士中长款','2020年秋季','言衡',198,'户外装','秋季','1.0kg','青少年','中式');
/*!40000 ALTER TABLE `commodity_clothing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_food`
--

DROP TABLE IF EXISTS `commodity_food`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity_food` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity_id` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `food_type` varchar(45) DEFAULT NULL,
  `food_weight` varchar(45) DEFAULT NULL,
  `origin` varchar(45) DEFAULT NULL,
  `production_license_number` varchar(45) DEFAULT NULL,
  `product_standard_number` varchar(45) DEFAULT NULL,
  `net_content` varchar(45) DEFAULT NULL,
  `ex` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_food`
--

LOCK TABLES `commodity_food` WRITE;
/*!40000 ALTER TABLE `commodity_food` DISABLE KEYS */;
INSERT INTO `commodity_food` VALUES (19,'food20210414063300577','奥利奥（Oreo）原味夹心饼干',20,'饼干','370.00g','北京、苏州湖东','sc112408010002','sc112408010002',NULL,'否'),(21,'food20210611080442934','螺霸王 螺蛳粉330g*6 广西柳州特产 ',77,'汤面','2.56kg','广西柳州','DBS 45/034','SC10445020400052',NULL,'否'),(22,'food20210611081508732','康师傅方便面红烧牛肉袋面泡面五连包休闲零食 ',13,'汤面','0.61kg','中国','GB17400LS/T3211 ','SC10712011605164',NULL,'否'),(23,'food20210611082836680','蒙牛 特仑苏 纯牛奶 ',87,'纯牛奶','4.66kg','中国大陆','weqweqwe','231d21d',NULL,'否'),(24,'food20210611084555630','福临门 本来长粒香米',40,'大米','5.08kg','绥化','dqwdqd','dqdqd',NULL,'否'),(25,'food20210611084900949',' 西王玉米胚芽油6.18L',125,'食用油','5.85kg','山东','SC10237162600050','Q/XSP 0003S-2021',NULL,'否'),(26,'food20210611090423388',' 爱普诗（Alpes d\'Or）',109,'黑巧克力','0.524','瑞士','wdqdqd231','ssdcq3123',NULL,'否'),(27,'food20210611091311284','卫龙大面筋 ',3,'小吃','70.00g','中国大陆','SC10741119100167','Q/LHPP 0004S',NULL,'否');
/*!40000 ALTER TABLE `commodity_food` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_furniture`
--

DROP TABLE IF EXISTS `commodity_furniture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity_furniture` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity_id` varchar(45) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `price` int DEFAULT NULL,
  `furniture_material` varchar(45) DEFAULT NULL,
  `scene` varchar(45) DEFAULT NULL,
  `function_type` varchar(45) DEFAULT NULL,
  `furniture_weight` varchar(45) DEFAULT NULL,
  `room` varchar(45) DEFAULT NULL,
  `furniture_style` varchar(45) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `furniture_area` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_furniture`
--

LOCK TABLES `commodity_furniture` WRITE;
/*!40000 ALTER TABLE `commodity_furniture` DISABLE KEYS */;
INSERT INTO `commodity_furniture` VALUES (14,'fur20210409095627723','沙发',198000,'实木','','沙发','1T','客厅','北欧','KaTsuNo','189CM'),(15,'fur20210414064721307','钢化玻璃电视柜茶几组合',318,'人造板','','茶几','35.0kg','客厅','现代中式','众创造新','100'),(16,'fur20210615223438219','多用途脏衣篮',97,'塑料','','脏衣篮/桶','100.00g','卫生间','日式','利快','12'),(17,'fur20210615223636791','爱丽思（IRIS）',598,'塑料','','收纳柜','15.5kg','卧室','简约','爱丽思（IRIS）','32'),(18,'fur20210615223959655','意式极简科技布艺沙发',1980,'科技布;海绵','','沙发','30.0kg','客厅','现代简约','上林春天','28');
/*!40000 ALTER TABLE `commodity_furniture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_order`
--

DROP TABLE IF EXISTS `commodity_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(45) NOT NULL,
  `commodity_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_order`
--

LOCK TABLES `commodity_order` WRITE;
/*!40000 ALTER TABLE `commodity_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `commodity_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_other`
--

DROP TABLE IF EXISTS `commodity_other`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity_other` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity_id` varchar(45) DEFAULT NULL,
  `commodity_name` varchar(45) DEFAULT NULL,
  `commodity_type` varchar(45) DEFAULT NULL,
  `commodity_intro` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_other`
--

LOCK TABLES `commodity_other` WRITE;
/*!40000 ALTER TABLE `commodity_other` DISABLE KEYS */;
INSERT INTO `commodity_other` VALUES (14,'other20210414062600227','尼康（Nikon） AF-S 50mm f/1.8G 镜头','镜头','镜头',' 1580.00');
/*!40000 ALTER TABLE `commodity_other` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_phone`
--

DROP TABLE IF EXISTS `commodity_phone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity_phone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity_id` varchar(45) DEFAULT NULL,
  `commodity_name` varchar(45) DEFAULT NULL,
  `market_time` varchar(45) DEFAULT NULL,
  `brand` varchar(45) DEFAULT NULL,
  `phone_cpu` varchar(45) DEFAULT NULL,
  `operating_system` varchar(45) DEFAULT NULL,
  `phone_width` varchar(45) DEFAULT NULL,
  `phone_thick` varchar(45) DEFAULT NULL,
  `phone_weight` varchar(45) DEFAULT NULL,
  `phone_length` varchar(45) DEFAULT NULL,
  `storage` varchar(45) DEFAULT NULL,
  `internal_storage` varchar(45) DEFAULT NULL,
  `screen_size` varchar(45) DEFAULT NULL,
  `screen_material` varchar(45) DEFAULT NULL,
  `battery_removable` varchar(45) DEFAULT NULL,
  `wireless_charging` varchar(45) DEFAULT NULL,
  `number_of_sim` varchar(45) DEFAULT NULL,
  `resolution` varchar(45) DEFAULT NULL,
  `Backshot_main_pixel` varchar(45) DEFAULT NULL,
  `Foreshot_main_pixel` varchar(45) DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_phone`
--

LOCK TABLES `commodity_phone` WRITE;
/*!40000 ALTER TABLE `commodity_phone` DISABLE KEYS */;
INSERT INTO `commodity_phone` VALUES (83,'phone20210327081312829','华为 HUAWEI Mate 40 Pro','2021-02-28T16:00:00.000Z','华为','麒麟9000 SoC芯片','安卓','199','198','111','991','908','16G','1899','钛合金','否','否','111','100*100','88888888','88888888',NULL,'6900'),(84,'phone20210327131738557','Redmi-9A','2021-04-05T16:00:00.000Z','小米','1111','2222','222','4124122','33132','111','4141224','21412414','21421513','5123123','213214','否','5G','333','890K','980K',NULL,'19000');
/*!40000 ALTER TABLE `commodity_phone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodity_type`
--

DROP TABLE IF EXISTS `commodity_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commodity_type` (
  `ctid` int NOT NULL AUTO_INCREMENT,
  `commodity_id` varchar(45) DEFAULT NULL,
  `commodity_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`ctid`)
) ENGINE=InnoDB AUTO_INCREMENT=540 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodity_type`
--

LOCK TABLES `commodity_type` WRITE;
/*!40000 ALTER TABLE `commodity_type` DISABLE KEYS */;
INSERT INTO `commodity_type` VALUES (16,'book20210319173411976','学习'),(17,'book20210319173411976','科幻'),(18,'book20210319173411976','悬疑'),(19,'book20210319173411976','散文'),(20,'book20210319173411976','纪实'),(21,'book20210321111345726','学习'),(22,'book20210321111345726','科幻'),(23,'book20210321111345726','悬疑'),(24,'book20210321111345726','散文'),(25,'book20210321111345726','纪实'),(26,'book20210321111345726','小说'),(27,'book20210321111345726','文学'),(28,'book20210321111345726','传记'),(29,'book20210321111345726','惊悚'),(30,'book20210321111345726','绘本'),(31,'book20210321111345726','科普百科'),(32,'book20210321111345726','儿童文学'),(33,'book20210321111345726','幼儿启蒙'),(34,'book20210321111345726','动漫卡通'),(35,'book20210321111345726','少儿英语'),(36,'book20210321111345726','益智游戏'),(37,'book20210321111345726','中小教辅'),(38,'book20210321111345726','外语学习'),(39,'book20210321111345726','考试'),(40,'book20210321111345726','教材'),(41,'book20210321111345726','字典词典'),(42,'book20210321111345726','课外读物'),(43,'book20210321111345726','字帖'),(44,'book20210321111345726','考研'),(45,'book20210321111345726','初级会计'),(46,'book20210321111345726','教师资格'),(47,'book20210321111345726','二建'),(48,'book20210321111345726','四六级'),(49,'book20210321111345726','政治军事'),(50,'book20210321111345726','国学古籍'),(51,'book20210321111345726','心理'),(52,'book20210321111345726','哲学宗教'),(53,'book20210321111345726','社会科学'),(54,'book20210321111345726','文化'),(55,'book20210321111345726','法律'),(56,'book20210321111345726','心灵鸡汤'),(57,'book20210321111345726','社交'),(58,'book20210321111345726','口才'),(59,'book20210321111345726','管理'),(60,'book20210321111345726','经济'),(61,'book20210321111345726','投资'),(62,'book20210321111345726','会计'),(63,'book20210321111345726','营销'),(64,'book20210321111345726','美食'),(65,'book20210321111345726','家居'),(66,'book20210321111345726','体育'),(67,'book20210321111345726','健身保健'),(68,'book20210321111345726','美妆'),(69,'book20210321111345726','旅游地图'),(70,'book20210321111345726','绘画'),(71,'book20210321111345726','书法'),(72,'book20210321111345726','摄影'),(73,'book20210321111345726','音乐'),(74,'book20210321111345726','设计'),(75,'book20210321111345726','科普'),(76,'book20210321111345726','工业'),(77,'book20210321111345726','建筑'),(78,'book20210321111345726','医学'),(79,'book20210321111345726','电子'),(80,'book20210321111345726','编程语言'),(81,'book20210321111345726','计算机安全'),(82,'book20210321111345726','人工智能'),(83,'book20210321111345726','操作系统'),(84,'book20210321111345726','数据库'),(85,'book20210321111345726','英文原版'),(86,'book20210321111345726','日语原版'),(87,'book20210321111442654','学习'),(88,'book20210321111442654','科幻'),(89,'book20210321111442654','悬疑'),(90,'book20210321111442654','散文'),(91,'book20210321111442654','纪实'),(92,'book20210321111442654','小说'),(93,'book20210321111442654','文学'),(94,'book20210321111442654','传记'),(95,'book20210321111442654','惊悚'),(96,'book20210321111442654','绘本'),(97,'book20210321111442654','科普百科'),(98,'book20210321111442654','儿童文学'),(99,'book20210321111442654','幼儿启蒙'),(100,'book20210321111442654','动漫卡通'),(101,'book20210321111442654','少儿英语'),(102,'book20210321111442654','益智游戏'),(103,'book20210321111442654','中小教辅'),(104,'book20210321111442654','外语学习'),(105,'book20210321111442654','考试'),(106,'book20210321111442654','教材'),(107,'book20210321111442654','字典词典'),(108,'book20210321111442654','课外读物'),(109,'book20210321111442654','字帖'),(110,'book20210321111442654','考研'),(111,'book20210321111442654','初级会计'),(112,'book20210321111442654','教师资格'),(113,'book20210321111442654','二建'),(114,'book20210321111442654','四六级'),(115,'book20210321111442654','政治军事'),(116,'book20210321111442654','国学古籍'),(117,'book20210321111442654','心理'),(118,'book20210321111442654','哲学宗教'),(119,'book20210321111442654','社会科学'),(120,'book20210321111442654','文化'),(121,'book20210321111442654','法律'),(122,'book20210321111442654','心灵鸡汤'),(123,'book20210321111442654','社交'),(124,'book20210321111442654','口才'),(125,'book20210321111442654','管理'),(126,'book20210321111442654','经济'),(127,'book20210321111442654','投资'),(128,'book20210321111442654','会计'),(129,'book20210321111442654','营销'),(130,'book20210321111442654','美食'),(131,'book20210321111442654','家居'),(132,'book20210321111442654','体育'),(133,'book20210321111442654','健身保健'),(134,'book20210321111442654','美妆'),(135,'book20210321111442654','旅游地图'),(136,'book20210321111442654','绘画'),(137,'book20210321111442654','书法'),(138,'book20210321111442654','摄影'),(139,'book20210321111442654','音乐'),(140,'book20210321111442654','设计'),(141,'book20210321111442654','科普'),(142,'book20210321111442654','工业'),(143,'book20210321111442654','建筑'),(144,'book20210321111442654','医学'),(145,'book20210321111442654','电子'),(146,'book20210321111442654','编程语言'),(147,'book20210321111442654','计算机安全'),(148,'book20210321111442654','人工智能'),(149,'book20210321111442654','操作系统'),(150,'book20210321111442654','数据库'),(151,'book20210321111442654','英文原版'),(152,'book20210321111442654','日语原版'),(153,'book20210321144331127','学习'),(154,'book20210321144331127','科幻'),(155,'book20210321144331127','悬疑'),(156,'book20210321144331127','散文'),(157,'book20210321144331127','纪实'),(158,'book20210321144331127','小说'),(159,'book20210321144331127','文学'),(160,'book20210321144331127','传记'),(161,'book20210321144331127','惊悚'),(162,'book20210321144331127','绘本'),(163,'book20210321144331127','科普百科'),(164,'book20210321144331127','儿童文学'),(165,'book20210321144331127','幼儿启蒙'),(166,'book20210321144331127','动漫卡通'),(167,'book20210321144331127','少儿英语'),(168,'book20210321144331127','益智游戏'),(169,'book20210321144331127','中小教辅'),(170,'book20210321144331127','外语学习'),(171,'book20210321144331127','考试'),(172,'book20210321144331127','教材'),(173,'book20210321144331127','字典词典'),(174,'book20210321144331127','课外读物'),(175,'book20210321144331127','字帖'),(176,'book20210321144331127','考研'),(177,'book20210321144331127','初级会计'),(178,'book20210321144331127','教师资格'),(179,'book20210321144331127','二建'),(180,'book20210321144331127','四六级'),(181,'book20210321144331127','政治军事'),(182,'book20210321144331127','国学古籍'),(183,'book20210321144331127','心理'),(184,'book20210321144331127','哲学宗教'),(185,'book20210321144331127','社会科学'),(186,'book20210321144331127','文化'),(187,'book20210321144331127','法律'),(188,'book20210321144331127','心灵鸡汤'),(189,'book20210321144331127','社交'),(190,'book20210321144331127','口才'),(191,'book20210321144331127','管理'),(192,'book20210321144331127','经济'),(193,'book20210321144331127','投资'),(194,'book20210321144331127','会计'),(195,'book20210321144331127','营销'),(196,'book20210321144331127','美食'),(197,'book20210321144331127','家居'),(198,'book20210321144331127','体育'),(199,'book20210321144331127','健身保健'),(200,'book20210321144331127','美妆'),(201,'book20210321144331127','旅游地图'),(202,'book20210321144331127','绘画'),(203,'book20210321144331127','书法'),(204,'book20210321144331127','摄影'),(205,'book20210321144331127','音乐'),(206,'book20210321144331127','设计'),(207,'book20210321144331127','科普'),(208,'book20210321144331127','工业'),(209,'book20210321144331127','建筑'),(210,'book20210321144331127','医学'),(211,'book20210321144331127','电子'),(212,'book20210321144331127','编程语言'),(213,'book20210321144331127','计算机安全'),(214,'book20210321144331127','人工智能'),(215,'book20210321144331127','操作系统'),(216,'book20210321144331127','数据库'),(217,'book20210321144331127','英文原版'),(218,'book20210321144331127','日语原版'),(219,'book20210321144351664','学习'),(220,'book20210321144351664','科幻'),(221,'book20210321144351664','悬疑'),(222,'book20210321144351664','散文'),(223,'book20210321144351664','纪实'),(224,'book20210321144351664','小说'),(225,'book20210321144351664','文学'),(226,'book20210321144351664','传记'),(227,'book20210321144351664','惊悚'),(228,'book20210321144351664','绘本'),(229,'book20210321144351664','科普百科'),(230,'book20210321144351664','儿童文学'),(231,'book20210321144351664','幼儿启蒙'),(232,'book20210321144351664','动漫卡通'),(233,'book20210321144351664','少儿英语'),(234,'book20210321144351664','益智游戏'),(235,'book20210321144351664','中小教辅'),(236,'book20210321144351664','外语学习'),(237,'book20210321144351664','考试'),(238,'book20210321144351664','教材'),(239,'book20210321144351664','字典词典'),(240,'book20210321144351664','课外读物'),(241,'book20210321144351664','字帖'),(242,'book20210321144351664','考研'),(243,'book20210321144351664','初级会计'),(244,'book20210321144351664','教师资格'),(245,'book20210321144351664','二建'),(246,'book20210321144351664','四六级'),(247,'book20210321144351664','政治军事'),(248,'book20210321144351664','国学古籍'),(249,'book20210321144351664','心理'),(250,'book20210321144351664','哲学宗教'),(251,'book20210321144351664','社会科学'),(252,'book20210321144351664','文化'),(253,'book20210321144351664','法律'),(254,'book20210321144351664','心灵鸡汤'),(255,'book20210321144351664','社交'),(256,'book20210321144351664','口才'),(257,'book20210321144351664','管理'),(258,'book20210321144351664','经济'),(259,'book20210321144351664','投资'),(260,'book20210321144351664','会计'),(261,'book20210321144351664','营销'),(262,'book20210321144351664','美食'),(263,'book20210321144351664','家居'),(264,'book20210321144351664','体育'),(265,'book20210321144351664','健身保健'),(266,'book20210321144351664','美妆'),(267,'book20210321144351664','旅游地图'),(268,'book20210321144351664','绘画'),(269,'book20210321144351664','书法'),(270,'book20210321144351664','摄影'),(271,'book20210321144351664','音乐'),(272,'book20210321144351664','设计'),(273,'book20210321144351664','科普'),(274,'book20210321144351664','工业'),(275,'book20210321144351664','建筑'),(276,'book20210321144351664','医学'),(277,'book20210321144351664','电子'),(278,'book20210321144351664','编程语言'),(279,'book20210321144351664','计算机安全'),(280,'book20210321144351664','人工智能'),(281,'book20210321144351664','操作系统'),(282,'book20210321144351664','数据库'),(283,'book20210321144351664','英文原版'),(284,'book20210321144351664','日语原版'),(285,'book20210321144451432','学习'),(286,'book20210321144451432','科幻'),(287,'book20210321144451432','悬疑'),(288,'book20210321144451432','散文'),(289,'book20210321144451432','纪实'),(290,'book20210321144451432','小说'),(291,'book20210321144451432','文学'),(292,'book20210321144451432','传记'),(293,'book20210321144451432','惊悚'),(294,'book20210321144451432','绘本'),(295,'book20210321144451432','科普百科'),(296,'book20210321144451432','儿童文学'),(297,'book20210321144451432','幼儿启蒙'),(298,'book20210321144451432','动漫卡通'),(299,'book20210321144451432','少儿英语'),(300,'book20210321144451432','益智游戏'),(301,'book20210321144451432','中小教辅'),(302,'book20210321144451432','外语学习'),(303,'book20210321144451432','考试'),(304,'book20210321144451432','教材'),(305,'book20210321144451432','字典词典'),(306,'book20210321144451432','课外读物'),(307,'book20210321144451432','字帖'),(308,'book20210321144451432','考研'),(309,'book20210321144451432','初级会计'),(310,'book20210321144451432','教师资格'),(311,'book20210321144451432','二建'),(312,'book20210321144451432','四六级'),(313,'book20210321144451432','政治军事'),(314,'book20210321144451432','国学古籍'),(315,'book20210321144451432','心理'),(316,'book20210321144451432','哲学宗教'),(317,'book20210321144451432','社会科学'),(318,'book20210321144451432','文化'),(319,'book20210321144451432','法律'),(320,'book20210321144451432','心灵鸡汤'),(321,'book20210321144451432','社交'),(322,'book20210321144451432','口才'),(323,'book20210321144451432','管理'),(324,'book20210321144451432','经济'),(325,'book20210321144451432','投资'),(326,'book20210321144451432','会计'),(327,'book20210321144451432','营销'),(328,'book20210321144451432','美食'),(329,'book20210321144451432','家居'),(330,'book20210321144451432','体育'),(331,'book20210321144451432','健身保健'),(332,'book20210321144451432','美妆'),(333,'book20210321144451432','旅游地图'),(334,'book20210321144451432','绘画'),(335,'book20210321144451432','书法'),(336,'book20210321144451432','摄影'),(337,'book20210321144451432','音乐'),(338,'book20210321144451432','设计'),(339,'book20210321144451432','科普'),(340,'book20210321144451432','工业'),(341,'book20210321144451432','建筑'),(342,'book20210321144451432','医学'),(343,'book20210321144451432','电子'),(344,'book20210321144451432','编程语言'),(345,'book20210321144451432','计算机安全'),(346,'book20210321144451432','人工智能'),(347,'book20210321144451432','操作系统'),(348,'book20210321144451432','数据库'),(349,'book20210321144451432','英文原版'),(350,'book20210321144451432','日语原版'),(351,'book20210321145850808','学习'),(352,'book20210321145850808','科幻'),(353,'book20210321145850808','悬疑'),(354,'book20210321145850808','散文'),(355,'book20210321145850808','纪实'),(356,'book20210321145850808','小说'),(357,'book20210321145850808','文学'),(358,'book20210321145850808','传记'),(359,'book20210321145850808','惊悚'),(360,'book20210321145850808','绘本'),(361,'book20210321145850808','科普百科'),(362,'book20210321145850808','儿童文学'),(363,'book20210321145850808','幼儿启蒙'),(364,'book20210321145850808','动漫卡通'),(365,'book20210321145850808','少儿英语'),(366,'book20210321145850808','益智游戏'),(367,'book20210321145850808','中小教辅'),(368,'book20210321145850808','外语学习'),(369,'book20210321145850808','考试'),(370,'book20210321145850808','教材'),(371,'book20210321145850808','字典词典'),(372,'book20210321145850808','课外读物'),(373,'book20210321145850808','字帖'),(374,'book20210321145850808','考研'),(375,'book20210321145850808','初级会计'),(376,'book20210321145850808','教师资格'),(377,'book20210321145850808','二建'),(378,'book20210321145850808','四六级'),(379,'book20210321145850808','政治军事'),(380,'book20210321145850808','国学古籍'),(381,'book20210321145850808','心理'),(382,'book20210321145850808','哲学宗教'),(383,'book20210321145850808','社会科学'),(384,'book20210321145850808','文化'),(385,'book20210321145850808','法律'),(386,'book20210321145850808','心灵鸡汤'),(387,'book20210321145850808','社交'),(388,'book20210321145850808','口才'),(389,'book20210321145850808','管理'),(390,'book20210321145850808','经济'),(391,'book20210321145850808','投资'),(392,'book20210321145850808','会计'),(393,'book20210321145850808','营销'),(394,'book20210321145850808','美食'),(395,'book20210321145850808','家居'),(396,'book20210321145850808','体育'),(397,'book20210321145850808','健身保健'),(398,'book20210321145850808','美妆'),(399,'book20210321145850808','旅游地图'),(400,'book20210321145850808','绘画'),(401,'book20210321145850808','书法'),(402,'book20210321145850808','摄影'),(403,'book20210321145850808','音乐'),(404,'book20210321145850808','设计'),(405,'book20210321145850808','科普'),(406,'book20210321145850808','工业'),(407,'book20210321145850808','建筑'),(408,'book20210321145850808','医学'),(409,'book20210321145850808','电子'),(410,'book20210321145850808','编程语言'),(411,'book20210321145850808','计算机安全'),(412,'book20210321145850808','人工智能'),(413,'book20210321145850808','操作系统'),(414,'book20210321145850808','数据库'),(415,'book20210321145850808','英文原版'),(416,'book20210321145850808','日语原版'),(417,'book20210321150109525','学习'),(418,'book20210321150109525','科幻'),(419,'book20210321150109525','悬疑'),(420,'book20210321150109525','散文'),(421,'book20210321150109525','纪实'),(422,'book20210321150109525','小说'),(423,'book20210321150109525','文学'),(424,'book20210321150109525','传记'),(425,'book20210321150109525','惊悚'),(426,'book20210321150109525','绘本'),(427,'book20210321150109525','科普百科'),(428,'book20210321150109525','儿童文学'),(429,'book20210321150109525','幼儿启蒙'),(430,'book20210321150109525','动漫卡通'),(431,'book20210321150109525','少儿英语'),(432,'book20210321150109525','益智游戏'),(433,'book20210321150109525','中小教辅'),(434,'book20210321150109525','外语学习'),(435,'book20210321150109525','考试'),(436,'book20210321150109525','教材'),(437,'book20210321150109525','字典词典'),(438,'book20210321150109525','课外读物'),(439,'book20210321150109525','字帖'),(440,'book20210321150109525','考研'),(441,'book20210321150109525','初级会计'),(442,'book20210321150109525','教师资格'),(443,'book20210321150109525','二建'),(444,'book20210321150109525','四六级'),(445,'book20210321150109525','政治军事'),(446,'book20210321150109525','国学古籍'),(447,'book20210321150109525','心理'),(448,'book20210321150109525','哲学宗教'),(449,'book20210321150109525','社会科学'),(450,'book20210321150109525','文化'),(451,'book20210321150109525','法律'),(452,'book20210321150109525','心灵鸡汤'),(453,'book20210321150109525','社交'),(454,'book20210321150109525','口才'),(455,'book20210321150109525','管理'),(456,'book20210321150109525','经济'),(457,'book20210321150109525','投资'),(458,'book20210321150109525','会计'),(459,'book20210321150109525','营销'),(460,'book20210321150109525','美食'),(461,'book20210321150109525','家居'),(462,'book20210321150109525','体育'),(463,'book20210321150109525','健身保健'),(464,'book20210321150109525','美妆'),(465,'book20210321150109525','旅游地图'),(466,'book20210321150109525','绘画'),(467,'book20210321150109525','书法'),(468,'book20210321150109525','摄影'),(469,'book20210321150109525','音乐'),(470,'book20210321150109525','设计'),(471,'book20210321150109525','科普'),(472,'book20210321150109525','工业'),(473,'book20210321150109525','建筑'),(474,'book20210321150109525','医学'),(475,'book20210321150109525','电子'),(476,'book20210321150109525','编程语言'),(477,'book20210321150109525','计算机安全'),(478,'book20210321150109525','人工智能'),(479,'book20210321150109525','操作系统'),(480,'book20210321150109525','数据库'),(481,'book20210321150109525','英文原版'),(482,'book20210321150109525','日语原版'),(483,'book20210321151404502','小说'),(484,'book20210321151404502','科幻'),(485,'book20210321151404502','学习'),(486,'book20210321151404502','散文'),(487,'book20210321151404502','悬疑'),(488,'book20210321151530607','日语原版'),(489,'book20210322141911559','科幻'),(490,'book20210322141911559','小说'),(491,'book20210322143430964','散文'),(492,'book20210322143430964','小说'),(493,'book20210322143430964','科幻'),(494,'book20210322143731751','纪实'),(495,'book20210322143731751','学习'),(496,'book20210322143856850','散文'),(497,'book20210322143856850','文学'),(498,'book20210322144120615','学习'),(499,'book20210322144120615','散文'),(500,'book20210322144120615','小说'),(501,'book20210322184852963','学习'),(502,'book20210322184852963','编程语言'),(503,'book20210322185126322','编程语言'),(504,'book20210322185126322','学习'),(505,'book2021032218530258','编程语言'),(506,'book2021032218530258','计算机'),(507,'book2021032218530258','学习'),(508,'book20210322185452528','学习'),(509,'book20210322185452528','编程语言'),(510,'book20210322185452528','计算机'),(511,'book20210322185723401','学习'),(512,'book20210322185723401','计算机'),(513,'book20210322190208575','小说'),(514,'book20210322190208575','散文'),(515,'book20210322190208575','文学'),(516,'book20210322190352106','小说'),(517,'book20210322190352106','文学'),(518,'book20210322190702778','小说'),(519,'book20210322190702778','悬疑'),(520,'book20210322190838647','小说'),(521,'book20210322190838647','悬疑'),(522,'book2021032219101388','小说'),(523,'book20210322191453135','学习'),(524,'book20210322191453135','考试'),(525,'book20210322191635763','学习'),(526,'book20210322191635763','外语学习'),(527,'book20210322191635763','考试'),(528,'book20210322191808971','学习'),(529,'book20210322191808971','考试'),(530,'book20210322192112226','小说'),(531,'book20210322192112226','悬疑'),(532,'book20210322192301566','小说'),(533,'book20210322192301566','悬疑'),(534,'book20210322192422164','小说'),(535,'book20210326195151882','学习'),(536,'book20210326195151882','科幻'),(537,'book20210409093840415','学习'),(538,'book20210409093840415','散文'),(539,'book20210616085117599','学习');
/*!40000 ALTER TABLE `commodity_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `computer_category`
--

DROP TABLE IF EXISTS `computer_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `computer_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_type` varchar(45) DEFAULT NULL,
  `second_type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `computer_category`
--

LOCK TABLES `computer_category` WRITE;
/*!40000 ALTER TABLE `computer_category` DISABLE KEYS */;
INSERT INTO `computer_category` VALUES (1,'操作系统','Windows 10'),(3,'电脑类型','台式机'),(4,'品牌','微软'),(7,'品牌','华为'),(9,'电脑类型','笔记本'),(10,'电脑类型','一体机'),(12,'操作系统','window 7'),(13,'操作系统','window 8'),(14,'操作系统','Linux'),(15,'操作系统','Mac'),(16,'操作系统','鸿蒙'),(18,'品牌','小米'),(19,'品牌','得力'),(20,'品牌','联想'),(21,'品牌','苹果'),(24,'品牌','华硕'),(25,'品牌','宏基'),(26,'品牌','VIVO'),(27,'品牌','惠普');
/*!40000 ALTER TABLE `computer_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `homeimg`
--

DROP TABLE IF EXISTS `homeimg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `homeimg` (
  `id` int NOT NULL AUTO_INCREMENT,
  `img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `homeimg`
--

LOCK TABLES `homeimg` WRITE;
/*!40000 ALTER TABLE `homeimg` DISABLE KEYS */;
INSERT INTO `homeimg` VALUES (35,'images//home//mainImg20210501150041647.jpg'),(37,'images//home//mainImg20210501150626482.jpg');
/*!40000 ALTER TABLE `homeimg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logistics`
--

DROP TABLE IF EXISTS `logistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logistics` (
  `lid` int NOT NULL AUTO_INCREMENT,
  `logistics_id` varchar(45) DEFAULT NULL,
  `logistics_company` varchar(45) DEFAULT NULL,
  `logistics_status` varchar(45) DEFAULT NULL,
  `logistics_date` varchar(45) DEFAULT NULL,
  `dispatch` varchar(45) DEFAULT NULL,
  `receive` varchar(45) DEFAULT NULL,
  `receive_people` varchar(45) DEFAULT NULL,
  `dispatch_people` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`lid`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logistics`
--

LOCK TABLES `logistics` WRITE;
/*!40000 ALTER TABLE `logistics` DISABLE KEYS */;
INSERT INTO `logistics` VALUES (15,'log20210322193153290','顺丰','已送达','2021-03-22 19:31:53','大连','志摩市','志摩凛','勝野旭'),(16,'log2021032219504544','顺丰','已送达','2021-03-22 19:50:45','大连','各屋苑市','各务原抚子','勝野旭'),(17,'log20210323163901228','1','已送达','2021-03-23 16:39:01','1','各屋苑市','各务原抚子','1'),(18,'log20210323163904141','1','已送达','2021-03-23 16:39:04','1','各屋苑市','各务原抚子','1'),(19,'log20210323163918610','1','已送达','2021-03-23 16:39:18','1','志摩市','志摩凛','1'),(20,'log20210324141014615','顺丰','已送达','2021-03-24 14:10:14','大连','志摩市','志摩凛','勝野旭'),(21,'log20210326225348340','s','已送达','2021-03-26 22:53:48','s','志摩市','志摩凛','s'),(22,'log20210327131840233','zz','已送达','2021-03-27 13:18:40','zz','各屋苑市','各务原抚子','zz'),(23,'log2021032919114536','顺丰','已送达','2021-03-29 19:11:45','大连','志摩市','志摩凛','勝野旭'),(24,'log20210414064013930','中国邮政','已送达','2021-04-14 06:40:13','大连','志摩市','志摩凛','勝野旭'),(25,'log20210414064927448','顺丰','已送达','2021-04-14 06:49:27','大连','志摩市','志摩凛','勝野旭'),(26,'log20210414070059504','顺丰','已送达','2021-04-14 07:00:59','大连','志摩市','志摩凛','勝野旭'),(27,'log20210421211040389','顺丰','已送达','2021-04-21 21:10:40','123','志摩市','志摩凛123','勝野旭'),(28,'log2021052414110727','sf','已送达','2021-05-24 14:11:07','syx','志摩市','志摩凛123','syx'),(29,'log20210616085215449','SF','发货中','2021-06-16 08:52:15','123','辽宁省大连市高新园区波菲兰岛E座1单元1802','志摩凛wikao','123'),(30,'log20210616085215670','SF','发货中','2021-06-16 08:52:15','123','辽宁省大连市高新园区波菲兰岛E座1单元1802','志摩凛wikao','123');
/*!40000 ALTER TABLE `logistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_info`
--

DROP TABLE IF EXISTS `merchant_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `merchant_id` varchar(45) DEFAULT NULL,
  `merchant_name` varchar(45) DEFAULT NULL,
  `merchant_address` varchar(45) DEFAULT NULL,
  `merchant_number` varchar(45) DEFAULT NULL,
  `merchant_email` varchar(45) DEFAULT NULL,
  `person_id` varchar(45) DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `mer_intro` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_info`
--

LOCK TABLES `merchant_info` WRITE;
/*!40000 ALTER TABLE `merchant_info` DISABLE KEYS */;
INSERT INTO `merchant_info` VALUES (6,'mer20210322184201548','黑猫探戈~','辽宁省大连市','15734149495','1624197122@qq.com',NULL,'images//merchant//MI20210329190913723.jpg','计算机编程书店'),(7,'mer20210322184248180','各屋苑书店','各屋苑市','9891-8291','各屋苑书店',NULL,'images//merchant//MI20210322190037335.jpg','各屋苑市的一家书店'),(8,'mer20210322184325796','犬山书店','爱知县犬山市','6781-8260','犬山书店',NULL,'images//merchant//MI20210322191247967.jpg','卖教辅书'),(9,'mer202103221843584','折尾书店','折尾车站','0989-1192','折尾书店',NULL,'images//merchant//MI20210322191943637.jpg','书店老板不太对劲'),(10,'mer20210421211319186','tiao123','辽宁省大连市',NULL,'tiao123',NULL,'images//merchant//MI20210615072221515.jpg',NULL),(11,'mer2021061108001438','食品店','辽宁省大连市','1789879089789','食品店',NULL,'images//merchant//MI20210611080125787.jpg','卖食物的'),(12,'mer20210614202835273','123',NULL,NULL,'123',NULL,'images//merchant//MI20210614202954116.jpg',NULL);
/*!40000 ALTER TABLE `merchant_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_lo`
--

DROP TABLE IF EXISTS `merchant_lo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_lo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `merchantID` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_lo`
--

LOCK TABLES `merchant_lo` WRITE;
/*!40000 ALTER TABLE `merchant_lo` DISABLE KEYS */;
INSERT INTO `merchant_lo` VALUES (7,'ka123','ka123','mer20210322184201548'),(8,'Sheng123','Sheng123','mer20210322184248180'),(9,'tk123','tk123','mer20210322184325796'),(10,'lo123','lo123','mer202103221843584'),(11,'tiao123','tiao123','mer20210421211319186'),(12,'aoe123','aoe123','mer2021061108001438'),(13,'Wiki','123','mer20210614202835273');
/*!40000 ALTER TABLE `merchant_lo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `merchant_order`
--

DROP TABLE IF EXISTS `merchant_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `merchant_order` (
  `MOId` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(45) DEFAULT NULL,
  `merchant_id` varchar(45) DEFAULT NULL,
  `order_status` varchar(45) DEFAULT NULL,
  `logistics_id` varchar(45) DEFAULT NULL,
  `order_date` varchar(45) DEFAULT NULL,
  `user_address_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`MOId`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `merchant_order`
--

LOCK TABLES `merchant_order` WRITE;
/*!40000 ALTER TABLE `merchant_order` DISABLE KEYS */;
INSERT INTO `merchant_order` VALUES (26,'order20210322193036887','mer20210322184201548','已送达','log20210323163918610','2021-03-22 19:30:36','address20210322193002507'),(27,'order20210322193036928','mer20210322184248180','已送达','log20210324141014615','2021-03-22 19:30:36','address20210322193002507'),(28,'order20210322193036995','mer202103221843584','已送达','log20210322193153290','2021-03-22 19:30:36','address20210322193002507'),(29,'order20210322194653352','mer20210322184201548','已送达','log20210323163904141','2021-03-22 19:46:53','address20210322194640644'),(30,'order20210322194653406','mer20210322184248180','待处理',NULL,'2021-03-22 19:46:53','address20210322194640644'),(31,'order20210322194725456','mer20210322184201548','已送达','log2021032219504544','2021-03-22 19:47:25','address20210322194640644'),(32,'order20210325143650359','mer20210322184201548','已送达','log20210421211040389','2021-03-25 14:36:50','address20210322193002507'),(33,'order20210325144203317','mer20210322184248180','待处理',NULL,'2021-03-25 14:42:03','address20210322193002507'),(34,'order2021032622532954','mer20210322184201548','已送达','log20210326225348340','2021-03-26 22:53:29','address20210322193002507'),(35,'order20210327131831705','mer20210322184201548','已送达','log20210327131840233','2021-03-27 13:18:31','address20210322194640644'),(36,'order202103291902379','mer20210322184248180','待处理',NULL,'2021-03-29 19:02:37','address20210322193002507'),(37,'order2021032919023753','mer20210322184201548','已送达','log2021032919114536','2021-03-29 19:02:37','address20210322193002507'),(38,'order20210414061719308','mer20210322184201548','待处理',NULL,'2021-04-14 06:17:19','address20210322193002507'),(39,'order20210414063935510','mer20210322184201548','已送达','log20210414064013930','2021-04-14 06:39:35','address20210322193002507'),(40,'order20210414064847953','mer20210322184201548','已送达','log20210414064927448','2021-04-14 06:48:47','address20210322193002507'),(41,'order20210414070041651','mer20210322184201548','已送达','log20210414070059504','2021-04-14 07:00:41','address20210322193002507'),(42,'order20210421210550907','mer20210322184201548','待处理',NULL,'2021-04-21 21:05:50','address20210322193002507'),(43,'order20210421210550960','mer20210322184325796','待处理',NULL,'2021-04-21 21:05:50','address20210322193002507'),(44,'order20210429143820151','mer20210322184201548','待处理',NULL,'2021-04-29 14:38:20','address20210322193002507'),(45,'order20210501113618636','mer20210322184248180','待处理',NULL,'2021-05-01 11:36:18','address20210322193002507'),(46,'order20210501150901873','mer20210322184201548','待处理',NULL,'2021-05-01 15:09:01','address20210322193002507'),(47,'order20210524140950432','mer20210322184201548','已送达','log2021052414110727','2021-05-24 14:09:50','address20210322193002507'),(48,'order20210611071337299','mer20210322184201548','待处理',NULL,'2021-06-11 07:13:37','address20210515131119963'),(49,'order20210614094359227','mer20210322184201548','待处理',NULL,'2021-06-14 09:43:59','address20210515131119963'),(50,'order20210616084803408','mer20210322184201548','运送中','log20210616085215670','2021-06-16 08:48:03','address20210515131119963');
/*!40000 ALTER TABLE `merchant_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_info`
--

DROP TABLE IF EXISTS `order_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(100) NOT NULL,
  `commodity_id` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  `merchant_id` varchar(45) NOT NULL,
  `num` int NOT NULL,
  `user_address_id` varchar(45) DEFAULT NULL,
  `order_date` varchar(45) DEFAULT NULL,
  `order_wait_receive` varchar(45) DEFAULT NULL,
  `order_delivered` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=207 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_info`
--

LOCK TABLES `order_info` WRITE;
/*!40000 ALTER TABLE `order_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_main`
--

DROP TABLE IF EXISTS `order_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_main` (
  `oid` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(45) NOT NULL,
  `order_date` varchar(45) DEFAULT NULL,
  `user_address_id` varchar(45) DEFAULT NULL,
  `logistics_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_main`
--

LOCK TABLES `order_main` WRITE;
/*!40000 ALTER TABLE `order_main` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_product`
--

DROP TABLE IF EXISTS `order_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_product` (
  `oid` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(45) DEFAULT NULL,
  `commodity_id` varchar(45) DEFAULT NULL,
  `merchant_id` varchar(45) DEFAULT NULL,
  `num` varchar(45) DEFAULT NULL,
  `order_price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_product`
--

LOCK TABLES `order_product` WRITE;
/*!40000 ALTER TABLE `order_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_table`
--

DROP TABLE IF EXISTS `order_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_table` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_id` varchar(45) NOT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  `commodity_id` varchar(45) DEFAULT NULL,
  `logistics_id` varchar(45) DEFAULT NULL,
  `num` int DEFAULT NULL,
  `user_address_id` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_table`
--

LOCK TABLES `order_table` WRITE;
/*!40000 ALTER TABLE `order_table` DISABLE KEYS */;
INSERT INTO `order_table` VALUES (95,'order20210322193036887','ShiMaRin','book20210322185452528',NULL,1,'address20210322193002507','4'),(96,'order20210322193036928','ShiMaRin','book20210322190838647',NULL,1,'address20210322193002507','4'),(97,'order20210322193036928','ShiMaRin','book20210322190208575',NULL,1,'address20210322193002507','4'),(98,'order20210322193036995','ShiMaRin','book20210322192301566',NULL,1,'address20210322193002507','5'),(99,'order20210322194653352','ka123','book20210322185126322',NULL,2,'address20210322194640644','0'),(100,'order20210322194653406','ka123','book20210322190702778',NULL,1,'address20210322194640644','0'),(101,'order20210322194653406','ka123','book2021032219101388',NULL,1,'address20210322194640644','0'),(102,'order20210322194725456','ka123','book2021032218530258',NULL,1,'address20210322194640644','4'),(103,'order20210325143650359','ShiMaRin','book20210322185126322',NULL,1,'address20210322193002507','5'),(104,'order20210325143650359','ShiMaRin','book20210322185452528',NULL,1,'address20210322193002507','4'),(105,'order20210325143650359','ShiMaRin','book20210322184852963',NULL,1,'address20210322193002507','5'),(106,'order20210325144203317','ShiMaRin','book20210322190352106',NULL,1,'address20210322193002507','0'),(107,'order2021032622532954','ShiMaRin','computer20210326203943347',NULL,1,'address20210322193002507','5'),(108,'order20210327131831705','ka123','phone20210327131738557',NULL,1,'address20210322194640644','4'),(109,'order202103291902379','ShiMaRin','book20210322190838647',NULL,4,'address20210322193002507','0'),(110,'order2021032919023753','ShiMaRin','book2021032218530258',NULL,3,'address20210322193002507','5'),(111,'order2021032919023753','ShiMaRin','book20210322185452528',NULL,1,'address20210322193002507','5'),(112,'order20210414061719308','ShiMaRin','book2021032218530258',NULL,1,'address20210322193002507','0'),(113,'order20210414061719308','ShiMaRin','book20210322185452528',NULL,1,'address20210322193002507','0'),(114,'order20210414063935510','ShiMaRin','computer20210326204037430',NULL,1,'address20210322193002507','4'),(115,'order20210414064847953','ShiMaRin','fur20210409095627723',NULL,1,'address20210322193002507','5'),(116,'order20210414070041651','ShiMaRin','cloth20210414065849176',NULL,1,'address20210322193002507','5'),(117,'order20210421210550907','ShiMaRin','book20210322185126322',NULL,3,'address20210322193002507','0'),(118,'order20210421210550960','ShiMaRin','book20210322191453135',NULL,1,'address20210322193002507','0'),(119,'order20210429143820151','ShiMaRin','cloth20210414065849176',NULL,1,'address20210322193002507','0'),(120,'order20210501113618636','ShiMaRin','book20210322190702778',NULL,1,'address20210322193002507','0'),(121,'order20210501150901873','ShiMaRin','computer20210405164652221',NULL,1,'address20210322193002507','0'),(122,'order20210524140950432','ShiMaRin','cloth20210414065849176',NULL,1,'address20210322193002507','4'),(123,'order20210611071337299','ShiMaRin','book20210322185452528',NULL,2,'address20210515131119963','0'),(124,'order20210611071337299','ShiMaRin','book20210322185126322',NULL,2,'address20210515131119963','0'),(125,'order20210614094359227','ShiMaRin','book20210322185723401',NULL,4,'address20210515131119963','0'),(126,'order20210614094359227','ShiMaRin','book20210322185126322',NULL,1,'address20210515131119963','0'),(127,'order20210616084803408','ShiMaRin','book20210322185126322',NULL,1,'address20210515131119963','0');
/*!40000 ALTER TABLE `order_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `page_view`
--

DROP TABLE IF EXISTS `page_view`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `page_view` (
  `id` int NOT NULL AUTO_INCREMENT,
  `page_view` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `page_view`
--

LOCK TABLES `page_view` WRITE;
/*!40000 ALTER TABLE `page_view` DISABLE KEYS */;
INSERT INTO `page_view` VALUES (1,200);
/*!40000 ALTER TABLE `page_view` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales_commodity`
--

DROP TABLE IF EXISTS `sales_commodity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sales_commodity` (
  `id` int NOT NULL AUTO_INCREMENT,
  `commodity_id` varchar(100) DEFAULT NULL,
  `sales_num` int DEFAULT NULL,
  `ave_grade` varchar(5) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales_commodity`
--

LOCK TABLES `sales_commodity` WRITE;
/*!40000 ALTER TABLE `sales_commodity` DISABLE KEYS */;
INSERT INTO `sales_commodity` VALUES (13,'book20210322184852963',1,'5'),(14,'book20210322185126322',10,'5'),(15,'book2021032218530258',5,'4.625'),(16,'book20210322185452528',6,'4.25'),(17,'book20210322185723401',4,'no'),(18,'book20210322190208575',1,'4'),(19,'book20210322190352106',1,'no'),(20,'book20210322190702778',2,'no'),(21,'book20210322190838647',5,'4'),(22,'book2021032219101388',1,'no'),(23,'book20210322191453135',1,'no'),(24,'book20210322191635763',0,'no'),(25,'book20210322191808971',0,'no'),(26,'book20210322192112226',0,'no'),(27,'book20210322192301566',1,'5'),(28,'book20210322192422164',0,'no'),(29,'book20210326195151882',0,'no'),(30,'computer20210326203943347',1,'5'),(31,'computer20210326204037430',1,'4'),(32,'phone2021-03-27 07:41:51',0,'no'),(33,'phone2021-03-27 07:45:37',0,'no'),(34,'phone2021-03-27 07:48:07',0,'no'),(35,'phone2021-03-27 07:48:51',0,'no'),(36,'phone2021-03-27 07:50:26',0,'no'),(37,'phone2021-03-27 07:54:43',0,'no'),(38,'phone2021-03-27 07:56:26',0,'no'),(39,'phone2021-03-27 07:57:32',0,'no'),(40,'phone2021-03-27 08:00:15',0,'no'),(41,'phone2021-03-27 08:01:23',0,'no'),(42,'phone2021-03-27 08:02:55',0,'no'),(43,'phone2021-03-27 08:04:15',0,'no'),(44,'phone20210327080616431',0,'no'),(45,'phone20210327080725562',0,'no'),(46,'phone20210327080828833',0,'no'),(47,'phone20210327081312829',0,'no'),(48,'phone20210327131738557',1,'4'),(49,'fur20210327140526538',0,'no'),(50,'fur20210327152844926',0,'no'),(51,'fur20210327165215929',0,'no'),(52,'cloth20210327204837426',0,'no'),(53,'cloth20210327214051395',0,'no'),(54,'cloth2021032721512524',0,'no'),(55,'food20210327221702942',0,'no'),(56,'food2021032723030850',0,'no'),(57,'other20210328075023200',0,'no'),(58,'food2021032808540053',0,'no'),(59,'cloth20210328091744689',0,'no'),(60,'fur20210328092610478',0,'no'),(61,'food20210328093718782',0,'no'),(62,'other20210328100408449',0,'no'),(63,'other20210328100451269',0,'no'),(64,'other20210328100747767',0,'no'),(65,'food20210328100954159',0,'no'),(66,'food20210328101229551',0,'no'),(67,'food20210328101546823',0,'no'),(68,'food20210328101800190',0,'no'),(69,'fur20210328124710832',0,'no'),(70,'food20210329191044396',0,'no'),(71,'cloth20210405160426550',0,'no'),(72,'computer20210405163553798',0,'no'),(73,'computer20210405164652221',1,'no'),(74,'food20210409093254316',0,'no'),(75,'food20210409093718271',0,'no'),(76,'book20210409093840415',0,'no'),(77,'food20210409093934303',0,'no'),(78,'food20210409094051489',0,'no'),(79,'fur20210409095627723',1,'5'),(80,'other20210414062600227',0,'no'),(81,'food20210414063300577',0,'no'),(82,'cloth20210414063612845',0,'no'),(83,'fur20210414064721307',0,'no'),(84,'cloth20210414065849176',3,'4.5'),(85,'computer20210421210930275',0,'no'),(86,'food20210611072032638',0,'no'),(87,'food20210611080442934',0,'no'),(88,'food20210611081508732',0,'no'),(89,'food20210611082836680',0,'no'),(90,'food20210611084555630',0,'no'),(91,'food20210611084900949',0,'no'),(92,'food20210611090423388',0,'no'),(93,'food20210611091311284',0,'no'),(94,'2',2,'0'),(95,'computer20210614203338401',0,'no'),(96,'computer20210614203540797',0,'no'),(97,'computer20210614203926502',0,'no'),(98,'computer20210614204459215',0,'no'),(99,'computer20210614204843121',0,'no'),(100,'cloth20210615214956314',0,'no'),(101,'cloth20210615215345324',0,'no'),(102,'cloth20210615215631863',0,'no'),(103,'cloth20210615220408941',0,'no'),(104,'cloth20210615221608131',0,'no'),(105,'fur20210615223438219',0,'no'),(106,'fur20210615223636791',0,'no'),(107,'fur20210615223959655',0,'no'),(108,'book20210616085117599',0,'no');
/*!40000 ALTER TABLE `sales_commodity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `security_question`
--

DROP TABLE IF EXISTS `security_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `security_question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `que_id` varchar(45) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security_question`
--

LOCK TABLES `security_question` WRITE;
/*!40000 ALTER TABLE `security_question` DISABLE KEYS */;
INSERT INTO `security_question` VALUES (2,'qu1403202110252085','小学名称'),(4,'qu1403202115135685','初中名称'),(5,'qu1403202115140085','高中名称'),(6,'qu1503202110294285','大学名称');
/*!40000 ALTER TABLE `security_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping_cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `commodity_id` varchar(45) NOT NULL,
  `num` int DEFAULT NULL,
  `merchant_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=357 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
INSERT INTO `shopping_cart` VALUES (304,'ka123','book20210322190208575',0,'mer20210322184248180'),(346,'ShiMaRin','cloth20210414065849176',4,'mer20210322184201548'),(347,'ShiMaRin','phone20210327131738557',4,'mer20210322184201548'),(348,'ShiMaRin','computer20210405163553798',3,'mer20210322184201548'),(350,'ShiMaRin','cloth20210414063612845',3,'mer20210322184201548');
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testuser`
--

DROP TABLE IF EXISTS `testuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `testuser` (
  `id` int NOT NULL AUTO_INCREMENT,
  `userAccount` varchar(45) NOT NULL,
  `userPassword` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testuser`
--

LOCK TABLES `testuser` WRITE;
/*!40000 ALTER TABLE `testuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `testuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_acc`
--

DROP TABLE IF EXISTS `user_acc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_acc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `user_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_acc`
--

LOCK TABLES `user_acc` WRITE;
/*!40000 ALTER TABLE `user_acc` DISABLE KEYS */;
INSERT INTO `user_acc` VALUES (20,'ShiMaRin','123','ShiMaRin'),(21,'ka123','ka123','ka123'),(22,'tiao1','tiao123','tiao1'),(23,'123','123','123'),(24,'321','321','321'),(25,'zzz123','zzz123','zzz123'),(26,'aug123','aug123','aug123'),(27,'123321','123','123321'),(28,'aaa123','123','aaa123');
/*!40000 ALTER TABLE `user_acc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_address`
--

DROP TABLE IF EXISTS `user_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_address` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `user_name` varchar(45) NOT NULL,
  `tag` varchar(45) DEFAULT NULL,
  `user_address_id` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_address`
--

LOCK TABLES `user_address` WRITE;
/*!40000 ALTER TABLE `user_address` DISABLE KEYS */;
INSERT INTO `user_address` VALUES (21,'ShiMaRin','志摩市','志摩','','address20210322193002507','8738-2038'),(22,'ka123','各屋苑市','勝野旭','','address20210322194640644','1567-4567'),(24,'ShiMaRin','辽宁省大连市高新园区波菲兰岛E座1单元1802','勝野旭','','address20210515131119963','15734149495'),(25,'ShiMaRin','1','1','','address20210616084914415','1');
/*!40000 ALTER TABLE `user_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_commodity_evaluate`
--

DROP TABLE IF EXISTS `user_commodity_evaluate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_commodity_evaluate` (
  `eid` int NOT NULL,
  `commodity_id` varchar(45) DEFAULT NULL,
  `user_id` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`eid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_commodity_evaluate`
--

LOCK TABLES `user_commodity_evaluate` WRITE;
/*!40000 ALTER TABLE `user_commodity_evaluate` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_commodity_evaluate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_info`
--

DROP TABLE IF EXISTS `user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `phone` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `sex` varchar(45) DEFAULT NULL,
  `img` varchar(45) DEFAULT NULL,
  `user_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_info`
--

LOCK TABLES `user_info` WRITE;
/*!40000 ALTER TABLE `user_info` DISABLE KEYS */;
INSERT INTO `user_info` VALUES (16,'ShiMaRin','15734149495','shimarin@163.com','2002-03-04T16:00:00.000Z','男','images//userInfo//img28032021143829.jpg','志摩凛wikao'),(17,'ka123','15734149495','ka123@qq.com','2021-03-08T16:00:00.000Z','男','images//userInfo//img22032021194522.jpg','各务原抚子'),(18,'tiao1','15734149495','tiao@qq.com',NULL,NULL,NULL,NULL),(19,'123','123','123@qq.com',NULL,NULL,NULL,NULL),(20,'321','321123','321@qq.com',NULL,NULL,NULL,NULL),(21,'zzz123','15734149495','zzz123@qq.com',NULL,NULL,NULL,NULL),(22,'aug123','15734149495','1624197122@qq.com',NULL,'男','images//userInfo//img13062021230643.jpg','AUGYYDS'),(23,'123321','122334456','123@qq.com',NULL,NULL,NULL,NULL),(24,'aaa123','15734149495','12@qq.com',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_order`
--

DROP TABLE IF EXISTS `user_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_order` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) NOT NULL,
  `order_id` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_order`
--

LOCK TABLES `user_order` WRITE;
/*!40000 ALTER TABLE `user_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_security_question`
--

DROP TABLE IF EXISTS `user_security_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_security_question` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(45) DEFAULT NULL,
  `que_id` varchar(45) DEFAULT NULL,
  `ans` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_security_question`
--

LOCK TABLES `user_security_question` WRITE;
/*!40000 ALTER TABLE `user_security_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_security_question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-21 11:18:01
