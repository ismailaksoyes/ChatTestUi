package com.example.chattest.shared.mock_data

import com.example.chattest.domain.model.MessageDetailsUiModel
import com.example.chattest.domain.model.MessageUiModel
import com.example.chattest.shared.utils.MessageType

object MessageMock {

    fun getMessageList():List<MessageUiModel>{
        val message = arrayListOf<MessageUiModel>()
        message.add(MessageUiModel(0,"https://i.pinimg.com/736x/2e/d3/b8/2ed3b87f2e91cb1c9b25f40d4a2788e1.jpg","Hey, how's it goin?","Malena Tudi"))
        message.add(MessageUiModel(1,"https://i.pinimg.com/736x/2e/d3/b8/2ed3b87f2e91cb1c9b25f40d4a2788e1.jpg","Yo, are you going to the Jake’s wedding?","Jakob Curtis"))
        message.add(MessageUiModel(2,"https://i.pinimg.com/736x/2e/d3/b8/2ed3b87f2e91cb1c9b25f40d4a2788e1.jpg","Amir said we’d be staying over for a while... but ...","Abram Levin"))
        message.add(MessageUiModel(3,"https://i.pinimg.com/736x/2e/d3/b8/2ed3b87f2e91cb1c9b25f40d4a2788e1.jpg","hey, i got new memes for you","Marilyn Herwitz"))
        message.add(MessageUiModel(4,"https://i.pinimg.com/736x/2e/d3/b8/2ed3b87f2e91cb1c9b25f40d4a2788e1.jpg","GoT really took a nose dive huh","Desirae Saris"))
        return message
    }

    fun getMessageDetails():List<MessageDetailsUiModel>{
        val message = arrayListOf<MessageDetailsUiModel>()
        message.add(MessageDetailsUiModel(0,MessageType.RECEIVE,"we r goin to c the lions"))
        message.add(MessageDetailsUiModel(1,MessageType.RECEIVE,"they are doing a feed thing event at the zoo.."))
        message.add(MessageDetailsUiModel(2,MessageType.SEND,"when?"))
        message.add(MessageDetailsUiModel(3,MessageType.SEND,"see the lions or sea lions? also, is mac there with u??"))
        return message
    }
}