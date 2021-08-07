package kz.homecredit.core.base

import kotlinx.coroutines.flow.Flow

interface IBaseUseCase<in I, out R : Any> {
     operator fun invoke(input: I): Flow<R>
}
