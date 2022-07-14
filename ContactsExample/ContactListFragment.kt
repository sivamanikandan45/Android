package com.example.contactsexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ContactListFragment : Fragment() {
    private lateinit var manager:LinearLayoutManager
    private lateinit var recyclerView:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel:ContactViewModel by activityViewModels()
        recyclerView=view.findViewById(R.id.contact_recycler)
        recyclerView.setHasFixedSize(true)
        manager= LinearLayoutManager(context)
        recyclerView.layoutManager=manager
        val list=createList()
        val adapter=ListAdapter(list)
        recyclerView.adapter=adapter
        adapter.setOnItemClickListener(object : ListAdapter.ItemClickListener{
            override fun onItemClick(position: Int) {
                //replaceFragment()
                viewModel.contact.value=list[position]

                /*println("Item $position is clicked")
                println("${list[position].name}  ${list[position].phoneNumber}")*/

            }

        })
    }

    private fun createList(): List<Contact> {
        return mutableListOf<Contact>(
            Contact("Aurelia","3-878-258-4573"),
            Contact("Laila","7-604-326-0132"),
            Contact("Alma","6-601-328-4126"),
            Contact("Hope","1-202-554-4218"),
            Contact("Sara","7-602-541-7824"),
            Contact("Lorraine","0-366-423-7030"),
            Contact("Mandy","5-273-406-6423"),
            Contact("Caitlyn","1-751-046-1407"),
            Contact("Dakota","6-876-282-7888"),
            Contact("Abdul","4-665-027-7052"),
            Contact("Nathan","4-140-107-6267"),
            Contact("William","4-562-855-2004"),
            Contact("Aileen","4-786-357-7302"),
            Contact("Winnie","8-681-878-0710"),
            Contact("Carol","5-203-101-1487"),
            Contact("Lucas","2-710-434-1672"),
            Contact("Charlotte","6-886-578-6856"),
            Contact("Maggie","2-543-716-4408"),
            Contact("Rick","5-248-375-0322"),
            Contact("Dalia","8-563-230-5176"),
            Contact("Leilani","1-141-708-0252"),
            Contact("Sebastian","8-388-225-4107"),
            Contact("Isabella","4-604-466-2634"),
            Contact("Alice","2-726-844-8455"),
            Contact("Emely","3-558-060-8428"),
            Contact("Alexia","4-282-036-7061"),
            Contact("Cherish","3-580-031-8206"),
            Contact("Joyce","6-146-527-6020"),
            Contact("Caitlyn","1-553-833-8330"),
            Contact("Mackenzie","5-521-124-6643"),
            Contact("Abbey","7-632-377-3153"),
            Contact("Ethan","2-333-732-2614"),
            Contact("Gil","7-684-021-6564"),
            Contact("Tom","1-573-082-8803"),
            Contact("Sofia","8-071-474-3013"),
            Contact("Eden","0-636-672-7254"),
            Contact("Ethan","5-507-551-2208"),
            Contact("Macy","6-551-346-4744"),
            Contact("Nina","4-886-337-2272"),
            Contact("Owen","7-426-642-4162"),
            Contact("Sebastian","0-667-144-1023"),
            Contact("Catherine","4-573-628-6511"),
            Contact("Lily","8-073-156-1315"),
            Contact("Ron","6-646-271-0066"),
            Contact("Kieth","8-043-446-3443"),
            Contact("Gabriel","7-841-420-0422"),
            Contact("Tom","3-868-316-2556"),
            Contact("Goldie","0-522-111-1815"),
            Contact("Maxwell","3-684-614-4076"),
            Contact("Marilyn","1-871-361-7137"),
            Contact("Chester","1-663-600-1602"),
            Contact("Violet","4-400-755-8813"),
            Contact("Hayden","7-632-312-5067"),
            Contact("Chester","5-403-840-4256"),
            Contact("Ryan","1-512-535-7227"),
            Contact("Mason","1-824-722-5818"),
            Contact("Harmony","8-734-150-6853"),
            Contact("Livia","4-022-117-2211"),
            Contact("Enoch","4-782-316-2374"),
            Contact("Daphne","1-482-276-6722"),
            Contact("Wendy","6-585-516-3127"),
            Contact("Maxwell","2-070-274-0033"),
            Contact("Denis","3-005-554-3302"),
            Contact("Cara","2-070-105-0558"),
            Contact("Anthony","4-186-154-7752"),
            Contact("Benjamin","1-167-841-1542"),
            Contact("Jocelyn","2-467-418-5134"),
            Contact("Holly","6-334-344-5733"),
            Contact("Ilona","4-578-566-8200"),
            Contact("Hank","1-580-622-1676"),
            Contact("Carissa","6-354-031-7527"),
            Contact("Dakota","6-873-224-1285"),
            Contact("Ron","0-446-607-4823"),
            Contact("Aleksandra","5-734-217-0522"),
            Contact("Bob","4-584-405-3362"),
            Contact("Ruth","6-416-544-2657"),
            Contact("Ivy","4-054-113-1515"),
            Contact("Harvey","3-252-105-6327"),
            Contact("Johnathan","7-716-006-7456"),
            Contact("George","0-531-352-7026"),
            Contact("Lucas","6-180-675-3348"),
            Contact("Bart","4-707-573-5003"),
            Contact("Stella","1-586-542-6347"),
            Contact("Jane","7-216-032-2037"),
            Contact("Naomi","7-176-158-6504"),
            Contact("Carter","4-531-213-7004"),
            Contact("Cassandra","8-860-114-0517"),
            Contact("Nicholas","1-402-150-1868"),
            Contact("Carl","5-777-023-1680"),
            Contact("Jolene","3-287-343-8886"),
            Contact("Carter","8-270-160-0451"),
            Contact("Savannah","5-204-406-2161"),
            Contact("Sasha","3-416-800-1303"),
            Contact("Shelby","3-488-568-3818"),
            Contact("Tania","6-066-458-8347"),
            Contact("Madison","1-681-268-6522"),
            Contact("Doris","4-084-322-4383"),
            Contact("Clint","6-570-800-7513"),
            Contact("Irene","1-450-734-3180"),
            Contact("Dalia","5-526-744-6828"),
            Contact("Rachael","2-128-756-4067")
        )
    }

}