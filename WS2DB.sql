USE [master]
GO
/****** Object:  Database [Workshop1]    Script Date: 11/10/2018 10:41:25 AM ******/
CREATE DATABASE [Workshop1]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'WorkShop1', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\WorkShop1.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'WorkShop1_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\WorkShop1_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Workshop1] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Workshop1].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Workshop1] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Workshop1] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Workshop1] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Workshop1] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Workshop1] SET ARITHABORT OFF 
GO
ALTER DATABASE [Workshop1] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Workshop1] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Workshop1] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Workshop1] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Workshop1] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Workshop1] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Workshop1] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Workshop1] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Workshop1] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Workshop1] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Workshop1] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Workshop1] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Workshop1] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Workshop1] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Workshop1] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Workshop1] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Workshop1] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Workshop1] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Workshop1] SET  MULTI_USER 
GO
ALTER DATABASE [Workshop1] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Workshop1] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Workshop1] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Workshop1] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [Workshop1] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Workshop1]
GO
/****** Object:  Table [dbo].[tbl_Mobile]    Script Date: 11/10/2018 10:41:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_Mobile](
	[mobileId] [varchar](10) NOT NULL,
	[description] [varchar](250) NOT NULL,
	[price] [float] NULL,
	[mobileName] [varchar](20) NOT NULL,
	[yearOfProduction] [int] NULL,
	[quantity] [int] NULL,
	[notSale] [bit] NULL,
 CONSTRAINT [PK_tbl_Mobile] PRIMARY KEY CLUSTERED 
(
	[mobileId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_OrderDetails]    Script Date: 11/10/2018 10:41:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_OrderDetails](
	[orderDetailId] [int] IDENTITY(1,1) NOT NULL,
	[mobileId] [varchar](10) NOT NULL,
	[quantity] [int] NOT NULL,
	[price] [float] NOT NULL,
	[total] [float] NOT NULL,
	[orderId] [int] NOT NULL,
 CONSTRAINT [PK_tbl_OrderDetails_1] PRIMARY KEY CLUSTERED 
(
	[orderDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_Orders]    Script Date: 11/10/2018 10:41:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_Orders](
	[orderId] [int] IDENTITY(1,1) NOT NULL,
	[userId] [varchar](20) NOT NULL,
	[createdAt] [datetime] NULL,
 CONSTRAINT [PK_tbl_Orders] PRIMARY KEY CLUSTERED 
(
	[orderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbl_User]    Script Date: 11/10/2018 10:41:25 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbl_User](
	[userId] [varchar](20) NOT NULL,
	[password] [int] NOT NULL,
	[fullName] [varchar](50) NOT NULL,
	[role] [int] NULL,
 CONSTRAINT [PK_tbl_User] PRIMARY KEY CLUSTERED 
(
	[userId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'1', N'1i', 1, N'1', 1971, 1, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'2', N'2i', 1, N'1', 1970, 2, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'3', N'3i', 3, N'3', 3, 3, 1)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'4', N'4i', 4, N'4', 4, 4, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'7', N'7i', 7, N'7', 7, 7, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'8', N'8', 8, N'8', 8, 13, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'9 ', N'9', 9, N'9', 9, 447, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'id3', N'abcxyz', 12, N'Xiaomi', 2005, 43, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'id4', N's4', 121.213, N'Dell', 2021, 120, 0)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'id5', N's5', 2.32, N'Sharp', 2001, 319427, 1)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'rtwert', N'ert', 234, N'345', 2017, 432, 1)
INSERT [dbo].[tbl_Mobile] ([mobileId], [description], [price], [mobileName], [yearOfProduction], [quantity], [notSale]) VALUES (N'sadd', N'asdasd', 213, N'123', 1970, 120, 0)
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'admin', 123456, N'admin', 1)
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'staff', 123123, N'staff', 2)
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'stafff', 123321, N'staff213', 2)
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'user', 1, N'user', 0)
INSERT [dbo].[tbl_User] ([userId], [password], [fullName], [role]) VALUES (N'user2', 1, N'user2', 0)
ALTER TABLE [dbo].[tbl_Orders] ADD  CONSTRAINT [DF__tbl_Order__creat__164452B1]  DEFAULT (getdate()) FOR [createdAt]
GO
ALTER TABLE [dbo].[tbl_OrderDetails]  WITH CHECK ADD  CONSTRAINT [FK_Orders_OrderDetails] FOREIGN KEY([orderId])
REFERENCES [dbo].[tbl_Orders] ([orderId])
GO
ALTER TABLE [dbo].[tbl_OrderDetails] CHECK CONSTRAINT [FK_Orders_OrderDetails]
GO
ALTER TABLE [dbo].[tbl_Mobile]  WITH CHECK ADD  CONSTRAINT [CK_Positive_Num] CHECK  (([quantity]>=(0)))
GO
ALTER TABLE [dbo].[tbl_Mobile] CHECK CONSTRAINT [CK_Positive_Num]
GO
USE [master]
GO
ALTER DATABASE [Workshop1] SET  READ_WRITE 
GO
