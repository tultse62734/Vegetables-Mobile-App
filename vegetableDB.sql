USE [SmartFarm]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 3/19/2020 1:27:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[UserId] [int] NOT NULL,
	[UserPassword] [nvarchar](50) NULL,
	[UserName] [nvarchar](50) NULL,
	[UserAddress] [nvarchar](50) NULL,
	[UserPhoneNo] [nvarchar](50) NULL,
	[UserEmail] [nvarchar](50) NULL,
	[UserStatus] [int] NULL,
	[RoleId] [int] NULL,
 CONSTRAINT [PK_Customer_1] PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Category]    Script Date: 3/19/2020 1:27:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[CategoryId] [int] NOT NULL,
	[CategoryName] [nvarchar](50) NULL,
	[CategoryUrl] [text] NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[CategoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[DetailOrder]    Script Date: 3/19/2020 1:27:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DetailOrder](
	[DetailOrderId] [int] IDENTITY(1,1) NOT NULL,
	[OrderId] [int] NOT NULL,
	[ProductId] [int] NOT NULL,
	[Quantity] [int] NOT NULL,
 CONSTRAINT [PK_DetailOrder_1] PRIMARY KEY CLUSTERED 
(
	[DetailOrderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Order]    Script Date: 3/19/2020 1:27:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[OrderId] [int] IDENTITY(1,1) NOT NULL,
	[UserId] [int] NOT NULL,
	[OrderDate] [date] NULL,
	[Total] [float] NULL,
	[Notes] [nvarchar](500) NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[OrderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Payment]    Script Date: 3/19/2020 1:27:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Payment](
	[PaymentId] [int] IDENTITY(1,1) NOT NULL,
	[Amount] [nchar](10) NULL,
	[OrderId] [int] NULL,
	[PaymentStatus] [int] NULL,
 CONSTRAINT [PK_Payment] PRIMARY KEY CLUSTERED 
(
	[PaymentId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Product]    Script Date: 3/19/2020 1:27:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProId] [int] IDENTITY(1,1) NOT NULL,
	[StoreId] [nvarchar](50) NULL,
	[ProName] [nvarchar](50) NULL,
	[ProPrice] [float] NULL,
	[ProImage] [text] NULL,
	[ProQuantity] [int] NULL,
	[ProDescription] [nvarchar](50) NULL,
	[ProStatus] [int] NULL,
	[CategoryId] [int] NULL,
 CONSTRAINT [PK_Product_1] PRIMARY KEY CLUSTERED 
(
	[ProId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Role]    Script Date: 3/19/2020 1:27:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[RoleId] [int] NOT NULL,
	[RoleName] [nvarchar](50) NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[RoleId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Store]    Script Date: 3/19/2020 1:27:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Store](
	[StoreId] [nvarchar](50) NOT NULL,
	[UserId] [int] NOT NULL,
	[StoreName] [nvarchar](50) NULL,
	[StoreAddress] [nvarchar](50) NULL,
	[StoreImage] [nvarchar](max) NULL,
	[StorePhoneNo] [int] NULL,
	[StoreStatus] [int] NULL,
 CONSTRAINT [PK_Store] PRIMARY KEY CLUSTERED 
(
	[StoreId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
INSERT [dbo].[Account] ([UserId], [UserPassword], [UserName], [UserAddress], [UserPhoneNo], [UserEmail], [UserStatus], [RoleId]) VALUES (1, N'123', N'1', N'Q.9', N'123456789', N'mynt@fpt.edu.vn', 1, 2)
INSERT [dbo].[Category] ([CategoryId], [CategoryName], [CategoryUrl]) VALUES (1, N'Vegetables', N'https://i7.pngguru.com/preview/200/475/752/vegetable-auglis-cartoon-cartoon-vector-fruits-and-vegetables.jpg')
INSERT [dbo].[Category] ([CategoryId], [CategoryName], [CategoryUrl]) VALUES (2, N'Fruilt', N'https://png.pngtree.com/png-clipart/20190903/ourmid/pngtree-beautiful-mix-fruits-composition-png-image_1716779.jpg')
INSERT [dbo].[Category] ([CategoryId], [CategoryName], [CategoryUrl]) VALUES (3, N'Leafy Vegetables', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR5Yp7k1C5zQRZpizRRZP9P4cys9ELB4h66R20ndwRbSawn-K_99g&s')
INSERT [dbo].[Category] ([CategoryId], [CategoryName], [CategoryUrl]) VALUES (4, N'Organic', N'https://organicshop.com.vn/wp-content/uploads/2018/11/Feature-Image-Organic-farming-by-Green-Blender.jpg')
SET IDENTITY_INSERT [dbo].[Order] ON 

INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (6, 1, CAST(N'2019-12-09' AS Date), 0, N'Khuyến mãi 50%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (7, 1, CAST(N'2019-12-09' AS Date), 0, N'Khuyến mãi 50%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (8, 1, CAST(N'2019-12-09' AS Date), 0, N'Khuyến mãi 50%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (9, 1, CAST(N'2019-12-09' AS Date), 0, N'Khuyến mãi 50%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (10, 1, CAST(N'2019-12-09' AS Date), 0, N'Khuyến mãi 50%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (11, 1, CAST(N'2019-12-09' AS Date), 0, N'Khuyến mãi 50%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (14, 1, CAST(N'2019-12-09' AS Date), 0, N'Khuyến mãi 50%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (17, 1, CAST(N'2019-12-09' AS Date), 0, N'Khuyến mãi 50%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (19, 1, CAST(N'2019-12-09' AS Date), 0, N'Khuyến mãi 80%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (22, 1, CAST(N'2019-12-09' AS Date), 0, N'Khuyến mãi 80%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (26, 1, CAST(N'2019-12-09' AS Date), 130.07000732421875, N'Khuyến mãi 80%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (30, 1, CAST(N'2019-12-09' AS Date), 123, N'sdaasd')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (31, 1, CAST(N'2019-12-09' AS Date), 130.07000732421875, N'Khuyến mãi 80%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (32, 1, NULL, 80000, N'Khuyến mãi 50%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (34, 1, CAST(N'2019-09-19' AS Date), 80000, N'Khuyến mãi 50%')
INSERT [dbo].[Order] ([OrderId], [UserId], [OrderDate], [Total], [Notes]) VALUES (35, 1, CAST(N'2019-12-19' AS Date), 80000, N'Khuyến mãi 50%')
SET IDENTITY_INSERT [dbo].[Order] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ProId], [StoreId], [ProName], [ProPrice], [ProImage], [ProQuantity], [ProDescription], [ProStatus], [CategoryId]) VALUES (1, N'1', N'Chuối', 20000, N'https://vcdn-suckhoe.vnecdn.net/2019/12/01/intro-1565644398-1575134601-9257-1575134774.jpg', 10, N'Xuất xứ nông trại đà lạt', 1, 1)
INSERT [dbo].[Product] ([ProId], [StoreId], [ProName], [ProPrice], [ProImage], [ProQuantity], [ProDescription], [ProStatus], [CategoryId]) VALUES (2, N'1', N'Dưa Hấu', 15000, N'http://image.vinanet.vn/zoom/500/Uploaded/nguyenlanhuong/nongsan/duahau_HNEJ.jpg', 10, N'Xuất xứ Long An', 1, 1)
INSERT [dbo].[Product] ([ProId], [StoreId], [ProName], [ProPrice], [ProImage], [ProQuantity], [ProDescription], [ProStatus], [CategoryId]) VALUES (3, N'1', N'Táo', 80000, N'https://images.vov.vn/w720/uploaded/69lwz2nmezg/2019_06_04/2_fukz.jpg', 10, N'Xuất xứ Mỹ', 1, 2)
INSERT [dbo].[Product] ([ProId], [StoreId], [ProName], [ProPrice], [ProImage], [ProQuantity], [ProDescription], [ProStatus], [CategoryId]) VALUES (4, N'1', N'Cà Tím', 18000, N'http://icdn.dantri.com.vn/2018/4/11/photo-2-1523407580291903113210.jpg', 10, N'Xuất xứ đà lạt ', 1, 2)
INSERT [dbo].[Product] ([ProId], [StoreId], [ProName], [ProPrice], [ProImage], [ProQuantity], [ProDescription], [ProStatus], [CategoryId]) VALUES (5, N'1', N'Bắp Cải', 20000, N'https://trongraudothi.com/Uploads/rausach/rausach/avata/img/20190406103953H%E1%BA%A1t%20gi%E1%BB%91ng%20b%E1%BA%AFp%20c%E1%BA%A3i.jpg', 10, N'Xuất xứ đà lạt', 1, 2)
INSERT [dbo].[Product] ([ProId], [StoreId], [ProName], [ProPrice], [ProImage], [ProQuantity], [ProDescription], [ProStatus], [CategoryId]) VALUES (6, N'1', N'Dưa chuột', 15000, N'https://trongraudothi.com/Uploads/rausach/rausach/avata/img/20190406103953H%E1%BA%A1t%20gi%E1%BB%91ng%20b%E1%BA%AFp%20c%E1%BA%A3i.jpg', 20, N'Xuất xứ đà lạt', 1, 1)
INSERT [dbo].[Product] ([ProId], [StoreId], [ProName], [ProPrice], [ProImage], [ProQuantity], [ProDescription], [ProStatus], [CategoryId]) VALUES (7, N'1', N'Trái đào', 40000, N'https://i.a4vn.com/2012/11/21/cong-dung-duong-da-dep-hieu-qua-tu-trai-dao-0bacc7.jpg', 20, N'Xuất xứ Úc', 1, 3)
INSERT [dbo].[Product] ([ProId], [StoreId], [ProName], [ProPrice], [ProImage], [ProQuantity], [ProDescription], [ProStatus], [CategoryId]) VALUES (8, N'1', N'Trái dừa', 9000, N'https://lamthenao.com/uploads/2018/08/cach-lam-rau-cau-trai-dua-1.jpg', 20, N'Xuất xứ bến trái dừa nước cây', 1, 3)
INSERT [dbo].[Product] ([ProId], [StoreId], [ProName], [ProPrice], [ProImage], [ProQuantity], [ProDescription], [ProStatus], [CategoryId]) VALUES (9, N'1', N'Trái thanh loan', 12000, N'https://sohanews.sohacdn.com/thumb_w/660/2015/qua-thanh-long-1447852598596-0-0-312-424-crop-1447852787613.jpg', 20, N'Xuất xứ long an', 1, 3)
INSERT [dbo].[Product] ([ProId], [StoreId], [ProName], [ProPrice], [ProImage], [ProQuantity], [ProDescription], [ProStatus], [CategoryId]) VALUES (10, N'1', N'Trái nho', 120000, N'https://cachlammonngon.vn/wp-content/uploads/2016/07/soda-siro-nho-2.jpg', 20, N'Xuất xứ ở hoa kỳ', 1, 4)
SET IDENTITY_INSERT [dbo].[Product] OFF
INSERT [dbo].[Role] ([RoleId], [RoleName]) VALUES (1, N'Admin')
INSERT [dbo].[Role] ([RoleId], [RoleName]) VALUES (2, N'User')
INSERT [dbo].[Store] ([StoreId], [UserId], [StoreName], [StoreAddress], [StoreImage], [StorePhoneNo], [StoreStatus]) VALUES (N'1', 1, N'Store1', N'01 Le Van Viet Quan 9', N'https://thietkeshop247.com.vn/kcfinder/upload/images/Thiet-ke-shop-trai-cay-nho-dep.jpg%281%29.jpg', 123456789, 1)
INSERT [dbo].[Store] ([StoreId], [UserId], [StoreName], [StoreAddress], [StoreImage], [StorePhoneNo], [StoreStatus]) VALUES (N'2', 1, N'Store2', N'18 Cach Mang Thang Tam P.10 Q.3', N'https://sw001.hstatic.net/7/0fa606a23002ca/thiet-ke-noi-that-cua-hang-trai-cay-3_grande.jpg     ', 111111111, 1)
INSERT [dbo].[Store] ([StoreId], [UserId], [StoreName], [StoreAddress], [StoreImage], [StorePhoneNo], [StoreStatus]) VALUES (N'3', 1, N'Store3', N'378 Quang Trung P.2 Q.Gò Vấp', N'https://www.noithatmasta.com/temp/-uploaded-2017_thiet-ke-shop-trai-cay-chiphuong-binhtan-2_cr_1000x500.jpg', 83978087, 1)
/****** Object:  Index [IX_DetailOrder]    Script Date: 3/19/2020 1:27:41 PM ******/
ALTER TABLE [dbo].[DetailOrder] ADD  CONSTRAINT [IX_DetailOrder] UNIQUE NONCLUSTERED 
(
	[ProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Account]  WITH CHECK ADD  CONSTRAINT [FK_Account_Role] FOREIGN KEY([RoleId])
REFERENCES [dbo].[Role] ([RoleId])
GO
ALTER TABLE [dbo].[Account] CHECK CONSTRAINT [FK_Account_Role]
GO
ALTER TABLE [dbo].[DetailOrder]  WITH CHECK ADD  CONSTRAINT [FK_DetailOrder_Order] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Order] ([OrderId])
GO
ALTER TABLE [dbo].[DetailOrder] CHECK CONSTRAINT [FK_DetailOrder_Order]
GO
ALTER TABLE [dbo].[DetailOrder]  WITH CHECK ADD  CONSTRAINT [FK_DetailOrder_Product] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Product] ([ProId])
GO
ALTER TABLE [dbo].[DetailOrder] CHECK CONSTRAINT [FK_DetailOrder_Product]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_Account] FOREIGN KEY([UserId])
REFERENCES [dbo].[Account] ([UserId])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_Account]
GO
ALTER TABLE [dbo].[Payment]  WITH CHECK ADD  CONSTRAINT [FK_Payment_Order] FOREIGN KEY([OrderId])
REFERENCES [dbo].[Order] ([OrderId])
GO
ALTER TABLE [dbo].[Payment] CHECK CONSTRAINT [FK_Payment_Order]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Category] ([CategoryId])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Store] FOREIGN KEY([StoreId])
REFERENCES [dbo].[Store] ([StoreId])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Store]
GO
ALTER TABLE [dbo].[Store]  WITH CHECK ADD  CONSTRAINT [FK_Store_Account] FOREIGN KEY([UserId])
REFERENCES [dbo].[Account] ([UserId])
GO
ALTER TABLE [dbo].[Store] CHECK CONSTRAINT [FK_Store_Account]
GO
