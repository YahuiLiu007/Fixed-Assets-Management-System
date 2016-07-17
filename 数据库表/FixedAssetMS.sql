USE [FixedAssetMS]
GO
/****** Object:  Table [dbo].[AUser]    Script Date: 2016/7/17 17:32:40 ******/
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
/****** Object:  Table [dbo].[CategoryAndType]    Script Date: 2016/7/17 17:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CategoryAndType](
	[category] [nvarchar](50) NOT NULL,
	[type] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FixedAsset]    Script Date: 2016/7/17 17:32:40 ******/
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
/****** Object:  Table [dbo].[Lend]    Script Date: 2016/7/17 17:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lend](
	[fiexedasset_id] [int] NOT NULL,
	[auser_id] [int] NOT NULL,
	[lenddate] [date] NOT NULL,
	[purpose] [nvarchar](50) NOT NULL,
	[manager_id] [int] NOT NULL,
	[remark] [nvarchar](50) NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Manager]    Script Date: 2016/7/17 17:32:40 ******/
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
/****** Object:  Table [dbo].[Return]    Script Date: 2016/7/17 17:32:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Return](
	[fixedasset_id] [int] NOT NULL,
	[auser_id] [int] NOT NULL,
	[returndate] [date] NOT NULL,
	[returnstatus] [nvarchar](50) NOT NULL,
	[manager_id] [int] NOT NULL,
	[remark] [nvarchar](50) NULL
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Manager] ON 

INSERT [dbo].[Manager] ([id], [name], [password]) VALUES (1, N'admin     ', N'admin     ')
SET IDENTITY_INSERT [dbo].[Manager] OFF
USE [master]
GO
ALTER DATABASE [FixedAssetMS] SET  READ_WRITE 
GO
