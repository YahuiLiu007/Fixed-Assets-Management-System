USE [master]
GO
/****** Object:  Database [FixedAssetMS]    Script Date: 2016/7/17 18:33:45 ******/
CREATE DATABASE [FixedAssetMS]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'FixedAssetMS', FILENAME = N'E:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\FixedAssetMS.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'FixedAssetMS_log', FILENAME = N'E:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\FixedAssetMS_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [FixedAssetMS] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [FixedAssetMS].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [FixedAssetMS] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [FixedAssetMS] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [FixedAssetMS] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [FixedAssetMS] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [FixedAssetMS] SET ARITHABORT OFF 
GO
ALTER DATABASE [FixedAssetMS] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [FixedAssetMS] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [FixedAssetMS] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [FixedAssetMS] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [FixedAssetMS] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [FixedAssetMS] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [FixedAssetMS] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [FixedAssetMS] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [FixedAssetMS] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [FixedAssetMS] SET  DISABLE_BROKER 
GO
ALTER DATABASE [FixedAssetMS] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [FixedAssetMS] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [FixedAssetMS] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [FixedAssetMS] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [FixedAssetMS] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [FixedAssetMS] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [FixedAssetMS] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [FixedAssetMS] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [FixedAssetMS] SET  MULTI_USER 
GO
ALTER DATABASE [FixedAssetMS] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [FixedAssetMS] SET DB_CHAINING OFF 
GO
ALTER DATABASE [FixedAssetMS] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [FixedAssetMS] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [FixedAssetMS] SET DELAYED_DURABILITY = DISABLED 
GO
USE [FixedAssetMS]
GO
/****** Object:  Table [dbo].[AUser]    Script Date: 2016/7/17 18:33:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[AUser](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nchar](10) NOT NULL,
	[duty] [nvarchar](50) NOT NULL,
	[remark] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CategoryAndType]    Script Date: 2016/7/17 18:33:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CategoryAndType](
	[category] [nvarchar](50) NOT NULL,
	[type] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FixedAsset]    Script Date: 2016/7/17 18:33:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FixedAsset](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nchar](10) NOT NULL,
	[category] [nvarchar](50) NOT NULL,
	[type] [nvarchar](50) NOT NULL,
	[price] [int] NOT NULL,
	[indate] [date] NOT NULL,
	[status] [nvarchar](50) NOT NULL,
	[auser] [nchar](10) NULL,
	[remark] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Lend]    Script Date: 2016/7/17 18:33:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lend](
	[fixedasset_id] [int] NOT NULL,
	[auser_id] [int] NOT NULL,
	[lenddate] [date] NOT NULL,
	[purpose] [nvarchar](50) NOT NULL,
	[manager_id] [int] NOT NULL,
	[remark] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Manager]    Script Date: 2016/7/17 18:33:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Manager](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[name] [nchar](10) NOT NULL,
	[password] [nchar](10) NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Ret]    Script Date: 2016/7/17 18:33:45 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ret](
	[fixedasset_id] [int] NOT NULL,
	[auser_id] [int] NOT NULL,
	[returndate] [date] NOT NULL,
	[returnstatus] [nvarchar](50) NOT NULL,
	[manager_id] [int] NOT NULL,
	[remark] [nvarchar](50) NULL
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[AUser] ON 

INSERT [dbo].[AUser] ([id], [name], [duty], [remark]) VALUES (1, N'andy      ', N'ceo', NULL)
SET IDENTITY_INSERT [dbo].[AUser] OFF
INSERT [dbo].[CategoryAndType] ([category], [type]) VALUES (N'办公外设', N'打印机')
SET IDENTITY_INSERT [dbo].[FixedAsset] ON 

INSERT [dbo].[FixedAsset] ([id], [name], [category], [type], [price], [indate], [status], [auser], [remark]) VALUES (1, N'dell      ', N'办公外设', N'打印机', 100, CAST(N'1007-01-31' AS Date), N'正常', NULL, NULL)
SET IDENTITY_INSERT [dbo].[FixedAsset] OFF
INSERT [dbo].[Lend] ([fixedasset_id], [auser_id], [lenddate], [purpose], [manager_id], [remark]) VALUES (1, 1, CAST(N'2016-07-17' AS Date), N'adsfas', 1, N'a')
SET IDENTITY_INSERT [dbo].[Manager] ON 

INSERT [dbo].[Manager] ([id], [name], [password]) VALUES (1, N'admin     ', N'admin     ')
INSERT [dbo].[Manager] ([id], [name], [password]) VALUES (2, N'1         ', N'1         ')
SET IDENTITY_INSERT [dbo].[Manager] OFF
INSERT [dbo].[Ret] ([fixedasset_id], [auser_id], [returndate], [returnstatus], [manager_id], [remark]) VALUES (1, 1, CAST(N'2016-07-17' AS Date), N'', 2, N'fds')
USE [master]
GO
ALTER DATABASE [FixedAssetMS] SET  READ_WRITE 
GO
