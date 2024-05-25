package org.sparklely.sparkle.core.api

import org.sparklely.sparkle.core.events.MessagingEvents.Companion.onSendMessagingEvent
import org.sparklely.sparkle.core.messaging.Message
import org.sparklely.sparkle.core.messaging.Channel
class MessageSender {
    /**
     * 向特定频道发送消息
     * @param message 消息
     * @param channel 频道
     */
    suspend fun sendMessage(message: Message, channel: Channel) {
        onSendMessagingEvent.trigger(message,channel)
    }
}