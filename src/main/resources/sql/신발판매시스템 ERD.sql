USE twodb;

CREATE TABLE `tbl_user` (
    `user_id` INT NOT NULL AUTO_INCREMENT,
    `id` VARCHAR(20) NOT NULL,
    `password` VARCHAR(20) NOT NULL,
    `user_name` VARCHAR(20) NOT NULL,
    `auth` INT NOT NULL COMMENT '관리자 : 0 / 일반사용자 : 1 (default) / 점장 : 2',
    `money` INT NULL DEFAULT 0 COMMENT '충전하여 사용가능',
    `phone` VARCHAR(20) NULL,
    `address` VARCHAR(100) NULL,
    PRIMARY KEY (`user_id`),
    UNIQUE KEY `idx_user_id` (`id`)
);

CREATE TABLE `tbl_store` (
    `store_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL COMMENT '점장',
    `store_name` VARCHAR(255) NOT NULL,
    `store_phone` VARCHAR(150) NOT NULL,
    `store_address` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`store_id`),
    FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
    INDEX `idx_store_user` (`user_id`)
);

CREATE TABLE `tbl_brand` (
    `brand_id` INT NOT NULL AUTO_INCREMENT,
    `brand_name` VARCHAR(150) NOT NULL,
    PRIMARY KEY (`brand_id`)
);

CREATE TABLE `tbl_shoes_type` (
    `shoes_type_id` INT NOT NULL AUTO_INCREMENT,
    `shoes_type` VARCHAR(150) NOT NULL,
    PRIMARY KEY (`shoes_type_id`)
);

CREATE TABLE `tbl_shoes` (
    `shoes_id` INT NOT NULL AUTO_INCREMENT,
    `shoes_type_id` INT NOT NULL,
    `brand_id` INT NOT NULL,
    `shoes_name` VARCHAR(255) NOT NULL,
    `shoes_price` INT NOT NULL,
    `size` INT NOT NULL,
    PRIMARY KEY (`shoes_id`),
    FOREIGN KEY (`shoes_type_id`) REFERENCES `tbl_shoes_type` (`shoes_type_id`),
    FOREIGN KEY (`brand_id`) REFERENCES `tbl_brand` (`brand_id`),
    INDEX `idx_shoes_type` (`shoes_type_id`),
    INDEX `idx_shoes_brand` (`brand_id`)
);

CREATE TABLE `tbl_offline_sale` (
    `offline_sale_id` INT NOT NULL AUTO_INCREMENT,
    `store_id` INT NOT NULL,
    `shoes_id` INT NOT NULL,
    `quantity` INT NOT NULL,
    `sale_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`offline_sale_id`),
    FOREIGN KEY (`store_id`) REFERENCES `tbl_store` (`store_id`),
    FOREIGN KEY (`shoes_id`) REFERENCES `tbl_shoes` (`shoes_id`),
    INDEX `idx_offline_sale_store` (`store_id`),
    INDEX `idx_offline_sale_shoes` (`shoes_id`)
);

CREATE TABLE `tbl_offline_warehouse` (
    `offline_warehouse_id` INT NOT NULL AUTO_INCREMENT,
    `store_id` INT NOT NULL,
    `shoes_id` INT NOT NULL,
    `quantity` INT NOT NULL,
    PRIMARY KEY (`offline_warehouse_id`),
    FOREIGN KEY (`store_id`) REFERENCES `tbl_store` (`store_id`),
    FOREIGN KEY (`shoes_id`) REFERENCES `tbl_shoes` (`shoes_id`),
    INDEX `idx_offline_stock_store` (`store_id`),
    INDEX `idx_offline_stock_shoes` (`shoes_id`)
);

CREATE TABLE `tbl_cart` (
    `cart_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `shoes_id` INT NOT NULL,
    `cart_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`cart_id`),
    FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
    FOREIGN KEY (`shoes_id`) REFERENCES `tbl_shoes` (`shoes_id`),
    INDEX `idx_cart_user` (`user_id`),
    INDEX `idx_cart_shoes` (`shoes_id`)
);

CREATE TABLE `tbl_online_order` (
    `order_id` INT NOT NULL AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `total_price` INT NOT NULL,
    `order_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`),
    INDEX `idx_online_order_user` (`user_id`)
);

CREATE TABLE `tbl_online_order_detail` (
    `online_order_detail_id` INT NOT NULL AUTO_INCREMENT,
    `order_id` INT NOT NULL,
    `shoes_id` INT NOT NULL,
    `quantity` INT NOT NULL,
    PRIMARY KEY (`online_order_detail_id`),
    FOREIGN KEY (`order_id`) REFERENCES `tbl_online_order` (`order_id`),
    FOREIGN KEY (`shoes_id`) REFERENCES `tbl_shoes` (`shoes_id`),
    INDEX `idx_online_order_detail_order` (`order_id`),
    INDEX `idx_online_order_detail_shoes` (`shoes_id`)
);

CREATE TABLE `tbl_purchase_order` (
    `purchase_order_id` INT NOT NULL AUTO_INCREMENT,
    `store_id` INT NOT NULL,
    `shoes_id` INT NOT NULL,
    `quantity` INT NOT NULL,
    `request_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `status` VARCHAR(150) NOT NULL DEFAULT "승인요청",
    `completion_date` TIMESTAMP NULL,
    PRIMARY KEY (`purchase_order_id`),
    FOREIGN KEY (`store_id`) REFERENCES `tbl_store` (`store_id`),
    FOREIGN KEY (`shoes_id`) REFERENCES `tbl_shoes` (`shoes_id`),
    INDEX `idx_purchase_order_store` (`store_id`),
    INDEX `idx_purchase_order_shoes` (`shoes_id`)
);

CREATE TABLE `tbl_online_stock` (
    `online_stock_id` INT NOT NULL AUTO_INCREMENT,
    `shoes_id` INT NOT NULL,
    `quantity` INT NOT NULL,
    PRIMARY KEY (`online_stock_id`),
    FOREIGN KEY (`shoes_id`) REFERENCES `tbl_shoes` (`shoes_id`),
    INDEX `idx_online_stock_shoes` (`shoes_id`)
);