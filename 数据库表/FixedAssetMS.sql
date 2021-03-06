USE [FixedAssetMS]
GO
/****** Object:  Table [dbo].[AUser]    Script Date: 2016/7/17 20:57:22 ******/
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
/****** Object:  Table [dbo].[CategoryAndType]    Script Date: 2016/7/17 20:57:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CategoryAndType](
	[category] [nvarchar](50) NOT NULL,
	[type] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FixedAsset]    Script Date: 2016/7/17 20:57:22 ******/
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
	[auser_id] [int] NULL,
	[remark] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Lend]    Script Date: 2016/7/17 20:57:22 ******/
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
/****** Object:  Table [dbo].[Manager]    Script Date: 2016/7/17 20:57:22 ******/
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
/****** Object:  Table [dbo].[Ret]    Script Date: 2016/7/17 20:57:22 ******/
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
INSERT [dbo].[AUser] ([id], [name], [duty], [remark]) VALUES (2, N'boy       ', N'b', N'f')
INSERT [dbo].[AUser] ([id], [name], [duty], [remark]) VALUES (3, N'cendy     ', N'c', N'haha')
INSERT [dbo].[AUser] ([id], [name], [duty], [remark]) VALUES (4, N'dav       ', N'd', N'da')
SET IDENTITY_INSERT [dbo].[AUser] OFF
INSERT [dbo].[CategoryAndType] ([category], [type]) VALUES (N'计算机', N'台式')
INSERT [dbo].[CategoryAndType] ([category], [type]) VALUES (N'计算机', N'服务器')
INSERT [dbo].[CategoryAndType] ([category], [type]) VALUES (N'计算机', N'笔记本')
INSERT [dbo].[CategoryAndType] ([category], [type]) VALUES (N'办公外设', N'打印机')
INSERT [dbo].[CategoryAndType] ([category], [type]) VALUES (N'办公外设', N'复印机')
INSERT [dbo].[CategoryAndType] ([category], [type]) VALUES (N'数码产品', N'照相机')
SET IDENTITY_INSERT [dbo].[FixedAsset] ON 

INSERT [dbo].[FixedAsset] ([id], [name], [category], [type], [price], [indate], [status], [auser_id], [remark]) VALUES (1, N'戴尔      ', N'计算机', N'笔记本', 100, CAST(N'2016-06-16' AS Date), N'正常', 1 , NULL)
INSERT [dbo].[FixedAsset] ([id], [name], [category], [type], [price], [indate], [status], [auser_id], [remark]) VALUES (3, N'联想    ', N'计算机', N'台式', 100, CAST(N'2016-07-16' AS Date), N'正常', 0, NULL)
INSERT [dbo].[FixedAsset] ([id], [name], [category], [type], [price], [indate], [status], [auser_id], [remark]) VALUES (4, N'宏基      ', N'计算机', N'服务器', 100, CAST(N'2016-08-26' AS Date), N'正常', 1 , NULL)
INSERT [dbo].[FixedAsset] ([id], [name], [category], [type], [price], [indate], [status], [auser_id], [remark]) VALUES (5, N'佳能        ', N'办公外设', N'打印机', 200, CAST(N'2016-01-01' AS Date), N'正常', 0, NULL)
INSERT [dbo].[FixedAsset] ([id], [name], [category], [type], [price], [indate], [status], [auser_id], [remark]) VALUES (6, N'松下        ', N'办公外设', N'复印机', 30, CAST(N'2013-03-26' AS Date), N'报废', 0, NULL)
INSERT [dbo].[FixedAsset] ([id], [name], [category], [type], [price], [indate], [status], [auser_id], [remark]) VALUES (7, N'康佳        ', N'数码产品', N'照相机', 600, CAST(N'2016-01-01' AS Date), N'正常', 0, NULL)
INSERT [dbo].[FixedAsset] ([id], [name], [category], [type], [price], [indate], [status], [auser_id], [remark]) VALUES (8, N'索尼        ', N'数码产品', N'照相机', 700, CAST(N'2013-11-05' AS Date), N'正常', 0, NULL)
INSERT [dbo].[FixedAsset] ([id], [name], [category], [type], [price], [indate], [status], [auser_id], [remark]) VALUES (9, N'尼康        ', N'办公外设', N'复印机', 500, CAST(N'2014-06-15' AS Date), N'维修', 0, NULL)
SET IDENTITY_INSERT [dbo].[FixedAsset] OFF
INSERT [dbo].[Lend] ([fixedasset_id], [auser_id], [lenddate], [purpose], [manager_id], [remark]) VALUES (1, 1, CAST(N'2016-07-17' AS Date), N'打代码', 1, N'无')
INSERT [dbo].[Lend] ([fixedasset_id], [auser_id], [lenddate], [purpose], [manager_id], [remark]) VALUES (3, 2, CAST(N'2016-07-17' AS Date), N'上传代码', 1, N'无')
INSERT [dbo].[Lend] ([fixedasset_id], [auser_id], [lenddate], [purpose], [manager_id], [remark]) VALUES (4, 1, CAST(N'2016-07-17' AS Date), N'代码存储', 1, N'无')
SET IDENTITY_INSERT [dbo].[Manager] ON 

INSERT [dbo].[Manager] ([id], [name], [password]) VALUES (1, N'admin     ', N'admin     ')
INSERT [dbo].[Manager] ([id], [name], [password]) VALUES (2, N'hw        ', N'hw        ')
INSERT [dbo].[Manager] ([id], [name], [password]) VALUES (3, N'ad        ', N'ad        ')
SET IDENTITY_INSERT [dbo].[Manager] OFF
INSERT [dbo].[Ret] ([fixedasset_id], [auser_id], [returndate], [returnstatus], [manager_id], [remark]) VALUES (3, 2, CAST(N'2016-07-17' AS Date), N'正常', 1, N'无')
USE [master]
GO
ALTER DATABASE [FixedAssetMS] SET  READ_WRITE 
GO
