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
