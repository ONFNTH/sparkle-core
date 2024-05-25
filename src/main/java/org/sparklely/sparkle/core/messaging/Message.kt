package org.sparklely.sparkle.core.messaging

import org.sparklely.sparkle.core.user.Sender

interface Message {
    /**
     * 获取消息的字符串
     * @return 消息的字符串
     */
    override fun toString(): String

    /**
     * 获取消息的ID
     * @return 消息的ID
     */
    fun getId(): String

    /**
     * 获取消息的类型
     * @return 消息的类型
     */
    fun getType(): MessageTypes

    /**
     * 获取消息的发送者
     * @return 消息的发送者
     */

    fun getSender(): Sender

    /**
     * 获取消息的发送时间（使用毫秒为单位的时间戳）
     * @return 消息的发送时间
     */
    fun getSendTime(): Long
}